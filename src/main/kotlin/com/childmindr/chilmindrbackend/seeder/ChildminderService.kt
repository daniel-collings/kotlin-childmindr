package com.childmindr.chilmindrbackend.seeder

import com.childmindr.chilmindrbackend.model.Childminder
import com.childmindr.chilmindrbackend.model.relation.ChildminderService
import com.childmindr.chilmindrbackend.repository.ChildminderRepository
import com.childmindr.chilmindrbackend.repository.ChildminderServiceRepository
import com.childmindr.chilmindrbackend.repository.ServiceRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class ChildminderService(
    private val childminderServiceRepository: ChildminderServiceRepository,
    private val serviceSeeder: ServiceSeeder,
    private val childminderSeeder: ChildminderSeeder,
) {
    fun seedChildminderServices(): MutableIterable<ChildminderService> {
        val childminders = childminderSeeder.seedChildminders().toList()
        val services = serviceSeeder.seedServices().toList()


        val service1 = ChildminderService(
            childminderId = childminders[0].id,
            serviceId = services[0].id,
        )

        val service2 = ChildminderService(
            childminderId = childminders[1].id,
            serviceId = services[3].id,
        )

        return childminderServiceRepository.saveAll(listOf(service1, service2))
    }
}


