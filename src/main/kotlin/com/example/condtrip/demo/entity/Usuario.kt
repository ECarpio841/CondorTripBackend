package com.example.condtrip.demo.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "usuarios")
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val usuariosId: Int = 0,
    val nombre: String,
    val email: String,
    val contraseña: String,
    val puntos: Int
)
