package com.example.condtrip.demo.controller

import com.example.condtrip.demo.entity.PlanificadorRestaurantesUsuarios
import com.example.condtrip.demo.entity.PlanificadorRestaurantesUsuariosId
import com.example.condtrip.demo.services.PlanificadorRestaurantesUsuariosService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/planificador")
class PlanificadorRestaurantesUsuariosController(
    private val service: PlanificadorRestaurantesUsuariosService
) {
    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{idActividad}/{idUsuario}")
    fun getById(@PathVariable idActividad: Int, @PathVariable idUsuario: Int) =
        service.getById(PlanificadorRestaurantesUsuariosId(idActividad, idUsuario))

    @PostMapping
    fun create(@RequestBody data: PlanificadorRestaurantesUsuarios) = service.save(data)

    @PutMapping("/{idActividad}/{idUsuario}")
    fun update(
        @PathVariable idActividad: Int,
        @PathVariable idUsuario: Int,
        @RequestBody data: PlanificadorRestaurantesUsuarios
    ) = service.save(data.copy(idActividad = idActividad, idUsuario = idUsuario))

    @DeleteMapping("/{idActividad}/{idUsuario}")
    fun delete(@PathVariable idActividad: Int, @PathVariable idUsuario: Int) =
        service.delete(PlanificadorRestaurantesUsuariosId(idActividad, idUsuario))
}