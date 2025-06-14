package com.example.condtrip.demo.controller

import com.example.condtrip.demo.entity.Usuario
import com.example.condtrip.demo.services.UsuarioService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/usuarios")
class UsuarioController(private val service: UsuarioService) {

    @GetMapping
    fun getAll(): List<Usuario> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): Usuario? = service.getById(id)

    @PostMapping
    fun create(@RequestBody usuario: Usuario): Usuario = service.save(usuario)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody usuario: Usuario): Usuario =
        service.save(usuario.copy(usuariosId = id))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = service.delete(id)
}