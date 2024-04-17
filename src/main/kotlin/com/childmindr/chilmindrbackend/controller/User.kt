package com.childmindr.chilmindrbackend.controller

import com.childmindr.chilmindrbackend.model.User
import com.childmindr.chilmindrbackend.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {
    @PostMapping("/signup")
    fun signUp(@RequestBody signUpRequest: SignUpRequest) {
        return userService.signUp(
            email = signUpRequest.email,
            password = signUpRequest.password,
            firstName = signUpRequest.firstName,
            lastName = signUpRequest.lastName,
        )

    }

    @PostMapping("/signin")
    fun signIn(@RequestBody signInRequest: SignInRequest): User? {
        return userService.signIn(signInRequest.email, signInRequest.password)
    }

}

data class SignUpRequest(val email: String, val password: String, val firstName: String = "", val lastName: String = "")
data class SignInRequest(val email: String, val password: String)