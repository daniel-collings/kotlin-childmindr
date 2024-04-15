package com.childmindr.chilmindrbackend.controllers

import com.childmindr.chilmindrbackend.models.Childminder
import com.childmindr.chilmindrbackend.services.ChildminderService
import org.springframework.web.bind.annotation.*

@RestController
class ChildminderController(val service: ChildminderService) {
    @GetMapping("/")
    fun index(): List<Childminder> = service.findChildminders()

    @GetMapping("/{lat}/{lng}")
    fun getChildmindersByCoordinate(@PathVariable lat: Double, @PathVariable lng: Double, radius: Double = 5.0): List<Childminder> = service.findChildmindersByCoordinates(lat, lng, radius)

    @GetMapping("/")
    fun getChildmindersByCity(@RequestBody city: String): List<Childminder> = service.findChildmindersByCity(city)


    @GetMapping("/{id}")
    fun index(@PathVariable id: String): List<Childminder> =
        service.findChildminderById(id)

    @PostMapping("/")
    fun post(@RequestBody childminder: Childminder) {
        service.save(childminder)
    }

    @DeleteMapping("/{id}")
    fun delete(@RequestBody id: String) {
        service.deleteChildminderById(id)
    }
}