package com.childmindr.chilmindrbackend.seeder

import com.childmindr.chilmindrbackend.model.Childminder
import com.childmindr.chilmindrbackend.repository.ChildminderRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class ChildminderSeeder(
    private val userSeeder: UserSeeder,
    private val childminderRepository: ChildminderRepository,
    private val locationSeeder: LocationSeeder,
) {
    fun seedChildminders(): MutableIterable<Childminder> {
        val locations = locationSeeder.seedLocations().toList()
        val users = userSeeder.seedUsers().toList()


        val childminder1 = Childminder(
            UUID.randomUUID(),
            businessName = "Happy Hearts Daycare",
            intro = "Providing a warm and caring environment for children to learn and grow.",
            premium = false,
            registrationNo = "EY456798",
            locationId = locations[0].id,
            userId = users[0].id
        )

        val childminder2 = Childminder(
            UUID.randomUUID(),
            businessName = "Tiny Sprouts Childcare",
            intro = "Welcoming little ones each day, nurturing their curiosity and fostering growth.",
            premium = true,
            registrationNo = "EY151234",
            locationId = locations[1].id,
            userId = users[1].id
        )

        return childminderRepository.saveAll(listOf(childminder1, childminder2))
    }
}


