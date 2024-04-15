package com.childmindr.chilmindrbackend.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("profiles")
data class Profile(
    @Id val id: UUID,
    val contactNo: String,
    val waitingList: Boolean,
    val available: Boolean,
    val bio: String,
    val childminderId: UUID
)