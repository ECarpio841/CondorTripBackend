package com.example.condtrip.demo.dto

import com.example.condtrip.demo.entity.EstadoReserva
import java.util.Date

data class ReservaDTO(
    val usuarioId: Int,
    val actividadId: Int,
    val fechaReserva: Date,
    val cantidadPersonas: Int,
    val estado: EstadoReserva
)