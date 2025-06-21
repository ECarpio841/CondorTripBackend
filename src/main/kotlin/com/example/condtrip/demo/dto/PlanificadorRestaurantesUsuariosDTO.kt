package com.example.condtrip.demo.dto

import com.example.condtrip.demo.entity.EstadoPlanificacion

data class PlanificadorRestaurantesUsuariosDTO(
    val idActividad: Int,
    val idUsuario: Int,
    val estado: EstadoPlanificacion
)
