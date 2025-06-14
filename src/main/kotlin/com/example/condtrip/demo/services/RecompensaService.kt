package com.example.condtrip.demo.services

import com.example.condtrip.demo.entity.Recompensa
import com.example.condtrip.demo.repository.RecompensaRepository
import org.springframework.stereotype.Service

@Service
class RecompensaService(private val recompensaRepository: RecompensaRepository) {
    fun getAll(): List<Recompensa> = recompensaRepository.findAll()
    fun getById(id: Int): Recompensa? = recompensaRepository.findById(id).orElse(null)
    fun save(recompensa: Recompensa): Recompensa = recompensaRepository.save(recompensa)
    fun delete(id: Int) = recompensaRepository.deleteById(id)
}