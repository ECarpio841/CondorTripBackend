package com.example.condtrip.demo.services

import com.example.condtrip.demo.entity.Reserva
import com.example.condtrip.demo.repository.ReservaRepository
import org.springframework.stereotype.Service

@Service
class ReservaService(private val reservaRepository: ReservaRepository) {
    fun getAll(): List<Reserva> = reservaRepository.findAll()
    fun getById(id: Int): Reserva? = reservaRepository.findById(id).orElse(null)
    fun save(reserva: Reserva): Reserva = reservaRepository.save(reserva)
    fun delete(id: Int) = reservaRepository.deleteById(id)
}