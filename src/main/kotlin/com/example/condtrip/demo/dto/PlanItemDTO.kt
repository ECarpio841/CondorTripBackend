package com.example.condtrip.demo.dto

import java.time.LocalDateTime

data class PlanItemDTO(
    val planId: Int,
    val actividadId: Int,
    val descripcion: String,
    val fechaHora: LocalDateTime,
    val gasto: Float
)
