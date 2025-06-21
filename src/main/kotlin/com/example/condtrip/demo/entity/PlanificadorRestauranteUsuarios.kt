package com.example.condtrip.demo.entity

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import java.io.Serializable

@Entity
@IdClass(PlanificadorRestaurantesUsuariosId::class)
data class PlanificadorRestaurantesUsuarios(
    @Id
    val idActividad: Int,

    @Id
    val idUsuario: Int,

    @Enumerated(EnumType.STRING)
    val estado: EstadoPlanificacion
)

enum class EstadoPlanificacion { SUGERIDO, ACEPTADO, RECHAZADO }


data class PlanificadorRestaurantesUsuariosId(
    val idActividad: Int = 0,
    val idUsuario: Int = 0
) : Serializable
