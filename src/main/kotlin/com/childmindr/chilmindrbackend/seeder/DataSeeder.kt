package com.childmindr.chilmindrbackend.seeder
import org.springframework.stereotype.Component

@Component
class DataSeeder(
    private val userSeeder: UserSeeder,
    private val profileSeeder: ProfileSeeder,
    private val childminderSeeder: ChildminderSeeder,
    private val locationSeeder: LocationSeeder
) {
    fun seedData() {
        userSeeder.seedUsers()
        profileSeeder.seedProfiles()
        childminderSeeder.seedChildminders()
        locationSeeder.seedLocations()
    }
}