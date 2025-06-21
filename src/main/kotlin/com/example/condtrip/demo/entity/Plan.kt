package com.example.condtrip.demo.entity

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.math.BigDecimal
import java.time.LocalDate

@Entity
data class Plan(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @ManyToOne @JoinColumn(name = "id_usuario")
    val usuario: Usuario,

    val fechaCreacion: LocalDate,
    @Enumerated(EnumType.STRING)
    val compania: Compania,
    val presupuesto: BigDecimal
)