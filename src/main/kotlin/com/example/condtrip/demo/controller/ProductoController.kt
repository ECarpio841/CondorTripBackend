package com.example.condtrip.demo.controller

import com.example.condtrip.demo.entity.Producto
import com.example.condtrip.demo.services.ProductoService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/productos")
class ProductoController(private val service: ProductoService) {

    @GetMapping
    fun getAll(): List<Producto> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): Producto? = service.getById(id)

    @PostMapping
    fun create(@RequestBody producto: Producto): Producto = service.save(producto)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody producto: Producto): Producto =
        service.save(producto.copy(id = id))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = service.delete(id)
}