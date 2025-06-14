package com.example.condtrip.demo.entity

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Actividad(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val descripcion: String,
    val direccion: String,
    val horario: String,
    val telefono: String,
    val latitud: Float,
    val longitud: Float,
    @Enumerated(EnumType.STRING)
    val categoria: Categoria
)

enum class Categoria {
    CULTURAL, GASTRONOMICA, NATURAL, HISTORICA
}
