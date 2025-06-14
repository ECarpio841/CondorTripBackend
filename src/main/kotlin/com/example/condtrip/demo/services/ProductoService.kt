package com.example.condtrip.demo.services

import com.example.condtrip.demo.entity.Producto
import com.example.condtrip.demo.repository.ProductoRepository
import org.springframework.stereotype.Service

@Service
class ProductoService(private val productoRepository: ProductoRepository) {
    fun getAll(): List<Producto> = productoRepository.findAll()
    fun getById(id: Int): Producto? = productoRepository.findById(id).orElse(null)
    fun save(producto: Producto): Producto = productoRepository.save(producto)
    fun delete(id: Int) = productoRepository.deleteById(id)
}