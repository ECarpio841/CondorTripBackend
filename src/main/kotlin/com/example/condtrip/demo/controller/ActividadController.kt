package com.example.condtrip.demo.controller

import com.example.condtrip.demo.entity.Actividad
import com.example.condtrip.demo.services.ActividadService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/actividades")
class ActividadController(private val service: ActividadService) {

    @GetMapping
    fun getAll(): List<Actividad> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): Actividad? = service.getById(id)

    @PostMapping
    fun create(@RequestBody actividad: Actividad): Actividad = service.save(actividad)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody actividad: Actividad): Actividad =
        service.save(actividad.copy(id = id))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = service.delete(id)
}