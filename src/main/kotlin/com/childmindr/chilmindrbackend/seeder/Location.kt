package com.childmindr.chilmindrbackend.seeder

import com.childmindr.chilmindrbackend.model.Location
import com.childmindr.chilmindrbackend.repository.LocationRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class LocationSeeder(private val locationRepository: LocationRepository) {
    fun seedLocations(): MutableIterable<Location> {
        val location1 = Location(UUID.randomUUID(), "TS255RE", "Hartlepool", 54.676313, -1.218747)
        val location2 = Location(UUID.randomUUID(), "TS190NG", "Stockton", 54.581852, -1.331506)
        return locationRepository.saveAll(listOf(location1, location2))
    }
}