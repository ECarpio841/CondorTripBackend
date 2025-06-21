package com.example.condtrip.demo.entity

import com.fasterxml.jackson.annotation.JsonIdentityReference
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.util.Date

@Entity
data class Reserva(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIdentityReference(alwaysAsId = true)
    val usuario: Usuario,

    @ManyToOne
    @JoinColumn(name = "id_actividad")
    @JsonIdentityReference(alwaysAsId = true)
    val actividad: Actividad,

    val fechaReserva: Date,
    val cantidadPersonas: Int,
    @Enumerated(EnumType.STRING)
    val estado: EstadoReserva
)
enum class EstadoReserva { PENDIENTE, CONFIRMADA, CANCELADA }
