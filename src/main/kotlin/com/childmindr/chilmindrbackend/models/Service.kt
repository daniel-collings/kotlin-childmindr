package com.childmindr.chilmindrbackend.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("services")
data class Service(
    @Id val id: UUID,
    val name: String
)