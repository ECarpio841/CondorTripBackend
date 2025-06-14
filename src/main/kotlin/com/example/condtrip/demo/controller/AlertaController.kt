package com.example.condtrip.demo.controller

import com.example.condtrip.demo.entity.Alerta
import com.example.condtrip.demo.services.AlertaService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/alertas")
class AlertaController(private val service: AlertaService) {

    @GetMapping
    fun getAll(): List<Alerta> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): Alerta? = service.getById(id)

    @PostMapping
    fun create(@RequestBody alerta: Alerta): Alerta = service.save(alerta)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody alerta: Alerta): Alerta =
        service.save(alerta.copy(id = id))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = service.delete(id)
}