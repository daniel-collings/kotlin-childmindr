package com.childmindr.chilmindrbackend.models.relations

import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("childminder_services")
data class ChildminderService(
    val childminderId: UUID,
    val serviceId: UUID
)
