// com/example/condtrip/demo/dto/ActividadDTOs.kt
package com.example.condtrip.demo.dto

import com.example.condtrip.demo.entity.Categoria

data class ActividadCreateDTO(
    val descripcion: String,
    val direccion: String,
    val horario: String,
    val telefono: String,
    val latitud: Float,
    val longitud: Float,
    val categoria: Categoria,
    val usuarioId: Int
)

data class ActividadUpdateDTO(
    val descripcion: String,
    val direccion: String,
    val horario: String,
    val telefono: String,
    val latitud: Float,
    val longitud: Float,
    val categoria: Categoria
)

data class ActividadSummaryDTO(
    val id: Int,
    val descripcion: String,
    val direccion: String,
    val horario: String,
    val telefono: String,
    val latitud: Float,
    val longitud: Float,
    val categoria: Categoria,
    val hasImage: Boolean
)
