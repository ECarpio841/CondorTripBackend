package com.example.condtrip.demo.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.util.Date

@Entity
data class Alerta(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @ManyToOne @JoinColumn(name = "id_restaurante")
    val restaurante: Actividad,

    val titulo: String,
    val contenido: String,
    val fechaPublicacion: Date
)
