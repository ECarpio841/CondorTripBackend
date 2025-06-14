package com.example.condtrip.demo.services

import com.example.condtrip.demo.entity.Actividad
import com.example.condtrip.demo.repository.ActividadRepository
import org.springframework.stereotype.Service

@Service
class ActividadService(private val actividadRepository: ActividadRepository) {
    fun getAll(): List<Actividad> = actividadRepository.findAll()
    fun getById(id: Int): Actividad? = actividadRepository.findById(id).orElse(null)
    fun save(actividad: Actividad): Actividad = actividadRepository.save(actividad)
    fun delete(id: Int) = actividadRepository.deleteById(id)
}