package com.childmindr.chilmindrbackend.controllers

import com.childmindr.chilmindrbackend.models.Profile
import com.childmindr.chilmindrbackend.services.ProfileService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class ProfileController(val service: ProfileService) {
    @GetMapping("/{id}")
    fun index(@PathVariable id: UUID): List<Profile> =
        service.findProfileById(id)

    @PostMapping("/")
    fun post(@RequestBody childminderProfile: Profile) {
        service.save(childminderProfile)
    }

    @DeleteMapping("/{id}")
    fun delete(@RequestBody id: String) {
        service.deleteProfileById(id)
    }
}