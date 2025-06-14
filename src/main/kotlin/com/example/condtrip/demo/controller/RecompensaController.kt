package com.example.condtrip.demo.controller

import com.example.condtrip.demo.entity.Recompensa
import com.example.condtrip.demo.services.RecompensaService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/recompensas")
class RecompensaController(private val service: RecompensaService) {

    @GetMapping
    fun getAll(): List<Recompensa> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): Recompensa? = service.getById(id)

    @PostMapping
    fun create(@RequestBody recompensa: Recompensa): Recompensa = service.save(recompensa)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody recompensa: Recompensa): Recompensa =
        service.save(recompensa.copy(idRecompensas = id))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = service.delete(id)
}