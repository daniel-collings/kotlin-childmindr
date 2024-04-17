package com.childmindr.chilmindrbackend.seeder

import com.childmindr.chilmindrbackend.model.Service
import com.childmindr.chilmindrbackend.repository.ServiceRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ServiceSeeder(private val serviceRepository: ServiceRepository) {
    fun seedServices(): MutableIterable<Service> {
        val service1 = Service(UUID.randomUUID(), "Babysitting")
        val service2 = Service(UUID.randomUUID(), "Nursery Care")
        val service3 = Service(UUID.randomUUID(), "Preschools and Playgroups")
        val service4 = Service(UUID.randomUUID(), "Childminding Services")
        val service5 = Service(UUID.randomUUID(), "After School Clubs")
        val service6 = Service(UUID.randomUUID(), "Holiday Clubs")
        val service7 = Service(UUID.randomUUID(), "Breakfast Club")
        val service8 = Service(UUID.randomUUID(), "Wraparound Care")
        val service9 = Service(UUID.randomUUID(), "Parent and Toddler Groups")
        val service10 = Service(UUID.randomUUID(), "Wraparound Care")
        val service11 = Service(UUID.randomUUID(), "Out-of-School Care")
        val service12 = Service(UUID.randomUUID(), "Regulated Childcare Provision")
        val service13 = Service(UUID.randomUUID(), "School Run")

        return serviceRepository.saveAll(listOf(
            service1,
            service2,
            service3,
            service4,
            service5,
            service6,
            service7,
            service8,
            service9,
            service10,
            service11,
            service12,
            service13
        ))
    }
}