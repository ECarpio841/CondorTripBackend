package com.example.condtrip.demo.entity

@Entity
class RecompensaClaim(
  @Id @GeneratedValue var id: Int? = null,
  @ManyToOne var usuario: Usuario? = null,
  @ManyToOne var recompensa: Recompensa? = null,
  var fecha: Date? = null
)
