package com.childmindr.chilmindrbackend.repository

import com.childmindr.chilmindrbackend.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, String> {
    fun findByEmail(email: String): User?
}