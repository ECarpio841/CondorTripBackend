package com.example.condtrip.demo.services

import com.example.condtrip.demo.entity.PlanificadorRestaurantesUsuarios
import com.example.condtrip.demo.entity.PlanificadorRestaurantesUsuariosId
import com.example.condtrip.demo.repository.PlanificadorRestaurantesUsuariosRepository
import org.springframework.stereotype.Service


@Service
class PlanificadorRestaurantesUsuariosService(
    private val repo: PlanificadorRestaurantesUsuariosRepository
) {
    fun getAll(): List<PlanificadorRestaurantesUsuarios> = repo.findAll()
    fun getById(id: PlanificadorRestaurantesUsuariosId): PlanificadorRestaurantesUsuarios? =
        repo.findById(id).orElse(null)
    fun save(data: PlanificadorRestaurantesUsuarios): PlanificadorRestaurantesUsuarios = repo.save(data)
    fun delete(id: PlanificadorRestaurantesUsuariosId) = repo.deleteById(id)
}