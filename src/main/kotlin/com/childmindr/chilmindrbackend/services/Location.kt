package com.childmindr.chilmindrbackend.services

import com.childmindr.chilmindrbackend.models.Location
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import java.util.*
import kotlin.math.*
interface LocationRepository : CrudRepository<Location, String>

@Service
class LocationService(val db: LocationRepository) {
    fun findLocationsByLatLong(lat: Double, lng: Double, radius: Double): List<Location> {
        val earthRadius = 6371.0 // Earth's radius in kilometers

        return db.findAll().filter { entity ->
            val latDistance = Math.toRadians(entity.lat - lat)
            val lonDistance = Math.toRadians(entity.long - lng)
            val a = sin(latDistance / 2) * sin(latDistance / 2) +
                    cos(Math.toRadians(lat)) * cos(Math.toRadians(entity.lat)) *
                    sin(lonDistance / 2) * sin(lonDistance / 2)
            val c = 2 * atan2(sqrt(a), sqrt(1 - a))
            val distance = earthRadius * c

            distance <= radius / 1609.344 // Convert radius from miles to kilometers
        }.toList()
    }

    fun findLocationByCity(city: String): List<Location> = db.findAll().filter { entity ->
        entity.city == city
    }.toList()

    fun save(location: Location) {
        db.save(location)
    }



    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}