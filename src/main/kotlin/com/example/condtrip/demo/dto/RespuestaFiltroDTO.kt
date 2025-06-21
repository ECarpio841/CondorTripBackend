package com.example.condtrip.demo.dto

import com.example.condtrip.demo.entity.Compania
import java.math.BigDecimal
import java.time.LocalDate

data class RespuestaFiltroDTO(
    val usuarioId: Int,
    val fechaRespuesta: LocalDate,
    val compania: Compania,
    val presupuesto: BigDecimal,
    val interes: String
)