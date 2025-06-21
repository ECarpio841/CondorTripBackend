package com.example.condtrip.demo.dto

import com.example.condtrip.demo.entity.Compania
import java.math.BigDecimal
import java.time.LocalDate

data class PlanDTO(
    val usuarioId: Int,
    val fechaCreacion: LocalDate,
    val compania: Compania,
    val presupuesto: BigDecimal
)