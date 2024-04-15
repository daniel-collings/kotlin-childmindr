package com.childmindr.chilmindrbackend.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("users")
data class User(
    @Id val id: UUID,
    val firstName: String,
    val lastName: String,
    val email: String,
    val clerkId: UUID?
)