package com.childmindr.chilmindrbackend.services

import com.childmindr.chilmindrbackend.models.Profile
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import java.util.*

interface ProfileRepository : CrudRepository<Profile, String>

@Service
class ProfileService(val db: ProfileRepository) {
    fun findProfileById(id: UUID): List<Profile> = db.findAll().filter { entity ->
        entity.childminderId == id
    }.toList()

    fun save(profile: Profile) {
        db.save(profile)
    }

    fun deleteProfileById(id: String){
        db.deleteById(id)
    }


    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}