package com.childmindr.chilmindrbackend.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("locations")
data class Location(
    @Id val id: UUID,
    val postCode: String,
    val city: String,
    val lat: Double,
    val long: Double
)
