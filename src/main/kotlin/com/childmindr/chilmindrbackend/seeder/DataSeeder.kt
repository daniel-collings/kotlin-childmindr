package com.childmindr.chilmindrbackend.seeder
import org.springframework.stereotype.Component

@Component
class DataSeeder(
    private val userSeeder: UserSeeder,
    private val childminderSeeder: ChildminderSeeder,
    private val profileSeeder: ProfileSeeder,
    private val locationSeeder: LocationSeeder
) {
    fun seedData() {
        userSeeder.seedUsers()
        childminderSeeder.seedChildminders()
        profileSeeder.seedProfiles()
        locationSeeder.seedLocations()
    }
}