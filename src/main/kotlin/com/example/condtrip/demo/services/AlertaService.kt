package com.example.condtrip.demo.services

import com.example.condtrip.demo.entity.Alerta
import com.example.condtrip.demo.repository.AlertaRepository
import org.springframework.stereotype.Service

@Service
class AlertaService(private val alertaRepository: AlertaRepository) {
    fun getAll(): List<Alerta> = alertaRepository.findAll()
    fun getById(id: Int): Alerta? = alertaRepository.findById(id).orElse(null)
    fun save(alerta: Alerta): Alerta = alertaRepository.save(alerta)
    fun delete(id: Int) = alertaRepository.deleteById(id)
}
