package com.example.condtrip.demo.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class Recompensa(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idRecompensas: Int = 0,

    @ManyToOne @JoinColumn(name = "id_restaurante")
    val restaurante: Actividad,

    val nombre: String,
    val descripcion: String,
    val puntosNecesarios: Int
)
