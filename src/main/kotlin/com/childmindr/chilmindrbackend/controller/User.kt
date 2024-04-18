package com.childmindr.chilmindrbackend.controller

import com.childmindr.chilmindrbackend.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {
    @PostMapping("/sign-up")
    fun signUp(@RequestBody signUpRequest: SignUpRequest) {
        return userService.signUp(
            email = signUpRequest.email,
            password = signUpRequest.password,
            firstName = signUpRequest.firstName,
            lastName = signUpRequest.lastName,
        )
    }

    @PostMapping("/sign-in")
    fun signIn(@RequestBody signInRequest: SignInRequest): ResponseEntity<String> {
        val token = userService.signIn(signInRequest.email, signInRequest.password)
        if (token != null) {
            return ResponseEntity.ok(token)
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials")
        }
    }

}

data class SignUpRequest(val email: String, val password: String, val firstName: String = "", val lastName: String = "")
data class SignInRequest(val email: String, val password: String)