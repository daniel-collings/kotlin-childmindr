package com.childmindr.chilmindrbackend.controller

import com.childmindr.chilmindrbackend.model.Profile
import com.childmindr.chilmindrbackend.service.ProfileService
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("/api/profile")
@RestController
class ProfileController(val service: ProfileService) {
    @GetMapping("/{id}")
    fun index(@PathVariable id: UUID): List<Profile> =
        service.findProfileById(id)

    @PostMapping("/")
    fun post(@RequestBody childminderProfile: Profile) {
        service.save(childminderProfile)
    }

    @DeleteMapping("/")
    fun delete(@RequestBody id: String) {
        service.deleteProfileById(id)
    }
}