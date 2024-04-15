package com.childmindr.chilmindrbackend.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("childminders")
data class Childminder(
    @Id val id: UUID,
    val businessName: String,
    val intro: String,
    val premium: Boolean,
    val locationId: UUID,
    val userId: UUID
)
