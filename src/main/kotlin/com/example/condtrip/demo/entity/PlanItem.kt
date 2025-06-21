package com.example.condtrip.demo.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
data class PlanItem(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @ManyToOne @JoinColumn(name = "id_plan")
    val plan: Plan,

    @ManyToOne @JoinColumn(name = "id_actividad")
    val actividad: Actividad,

    val descripcion: String,
    val fechaHora: LocalDateTime,
    val gasto: Float
)