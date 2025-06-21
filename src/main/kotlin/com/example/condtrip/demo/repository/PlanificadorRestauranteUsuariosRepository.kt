package com.example.condtrip.demo.repository

import com.example.condtrip.demo.entity.PlanificadorRestaurantesUsuarios
import com.example.condtrip.demo.entity.PlanificadorRestaurantesUsuariosId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PlanificadorRestaurantesUsuariosRepository :
    JpaRepository<PlanificadorRestaurantesUsuarios, PlanificadorRestaurantesUsuariosId>