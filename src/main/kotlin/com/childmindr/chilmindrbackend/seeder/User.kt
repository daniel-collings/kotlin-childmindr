package com.childmindr.chilmindrbackend.seeder

import com.childmindr.chilmindrbackend.model.User
import com.childmindr.chilmindrbackend.repository.UserRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserSeeder(private val userRepository: UserRepository) {
    fun seedUsers(): MutableIterable<User> {
        val user1 = User(UUID.randomUUID(), "Tilly", "Watcham", "t.watcham1976@gmail.com", "test")
        val user2 = User(UUID.randomUUID(), "Betty", "Darroch", "elizabeth_darroch1@gmail.com", "test")
        return userRepository.saveAll(listOf(user1, user2))
    }
}