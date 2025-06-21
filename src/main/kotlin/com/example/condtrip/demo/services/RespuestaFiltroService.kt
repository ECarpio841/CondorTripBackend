package com.example.condtrip.demo.services

import com.example.condtrip.demo.entity.RespuestaFiltro
import com.example.condtrip.demo.repository.RespuestaFiltroRepository
import org.springframework.stereotype.Service

@Service
class RespuestaFiltroService(private val repo: RespuestaFiltroRepository) {
    fun getAll(): List<RespuestaFiltro> = repo.findAll()
    fun getById(id: Int): RespuestaFiltro? = repo.findById(id).orElse(null)
    fun save(data: RespuestaFiltro): RespuestaFiltro = repo.save(data)
    fun delete(id: Int) = repo.deleteById(id)
}