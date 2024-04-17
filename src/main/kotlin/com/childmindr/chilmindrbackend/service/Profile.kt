package com.childmindr.chilmindrbackend.service

import com.childmindr.chilmindrbackend.model.Profile
import com.childmindr.chilmindrbackend.repository.ProfileRepository
import org.springframework.stereotype.Service
import java.util.*


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