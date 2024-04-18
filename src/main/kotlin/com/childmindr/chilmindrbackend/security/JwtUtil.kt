package com.childmindr.chilmindrbackend.security

import org.springframework.stereotype.Component
import java.util.Date
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import java.nio.charset.StandardCharsets
import java.util.UUID

@Component
class JwtUtil {
    private val secretKey: String = System.getenv("SECRET_KEY") ?: "default-secret-key"

    private val key = Keys.hmacShaKeyFor(secretKey.toByteArray(StandardCharsets.UTF_8))
    private val validityInMilliseconds = 3600000 // 1 hour

    fun generateToken(id: UUID, email: String): String {
        val claims = Jwts.claims()
        claims["id"] = id.toString()
        claims["email"] = email

        val now = Date()
        val validity = Date(now.time + validityInMilliseconds)

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(validity)
            .signWith(key)
            .compact()
    }

    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token)
            true
        } catch (ex: Exception) {
            false
        }
    }

    fun extractUsername(token: String): String? {
        return try {
            val claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).body
            claims.subject
        } catch (ex: Exception) {
            null
        }
    }
}