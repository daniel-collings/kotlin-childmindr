package com.childmindr.chilmindrbackend.service

import com.childmindr.chilmindrbackend.model.User
import com.childmindr.chilmindrbackend.repository.UserRepository
import com.childmindr.chilmindrbackend.security.JwtUtil
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtUtil: JwtUtil
) {

    fun signUp(email: String, password: String, firstName: String, lastName: String) {
        val hashedPassword = passwordEncoder.encode(password)
        val user = User(
            id = UUID.randomUUID(),
            email = email,
            password = hashedPassword,
            firstName = firstName,
            lastName = lastName
        )
        userRepository.save(user)
    }

    fun signIn(email: String, password: String): String? {
        val user = userRepository.findByEmail(email)
        if (user != null) {
            val matches = passwordEncoder.matches(password, user.password)
            if (matches) {
                return jwtUtil.generateToken(email = user.email, id = user.id)
            }
        }
        return null
    }
}