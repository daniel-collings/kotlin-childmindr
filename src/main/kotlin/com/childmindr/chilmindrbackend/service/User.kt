package com.childmindr.chilmindrbackend.service

import com.childmindr.chilmindrbackend.model.User
import com.childmindr.chilmindrbackend.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {

    fun findUserByEmail(email: String): User? = userRepository.findByEmail(email)

    fun save(user: User) {
        userRepository.save(user)
    }

    fun deleteUserById(id: UUID) {
        userRepository.deleteById(id.toString())
    }

    fun signUp(email: String, password: String, firstName: String, lastName: String) {
        val user = User(
            id = UUID.randomUUID(),
            email = email,
            password = password,
            firstName = firstName ?: "",
            lastName = lastName ?: ""
            )
        return save(user)
    }

    fun signIn(email: String, password: String): User? {
        val user = findUserByEmail(email)
        return if (user != null && user.password == password) {
            user
        } else {
            null
        }
    }

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()

}