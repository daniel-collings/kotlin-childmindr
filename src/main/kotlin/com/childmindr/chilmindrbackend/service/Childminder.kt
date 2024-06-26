package com.childmindr.chilmindrbackend.service

import com.childmindr.chilmindrbackend.model.Childminder
import com.childmindr.chilmindrbackend.repository.ChildminderRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ChildminderService(
    val db: ChildminderRepository,
    private val locationService: LocationService
) {
    fun findChildminders(): List<Childminder> = db.findAll().toList()

    fun findChildminderById(id: String): List<Childminder> = db.findById(id).toList()

    fun save(childminder: Childminder) {
        db.save(childminder)
    }

    fun deleteChildminderById(id: String){
        db.deleteById(id)
    }

    fun findChildmindersByCoordinates(lat: Double, lng: Double, radius: Double = 5.0): List<Childminder> {
        val locations = locationService.findLocationsByLatLong(lat, lng, radius)
        val locationIds = locations.map { it.id }

        return db.findAll().filter { childminder ->
            childminder.locationId in locationIds
        }
    }

    fun findChildmindersByCity(city: String): List<Childminder> {
        val locations = locationService.findLocationByCity(city)
        val locationIds = locations.map { it.id }

        return db.findAll().filter { childminder ->
            childminder.locationId in locationIds
        }
    }



    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}