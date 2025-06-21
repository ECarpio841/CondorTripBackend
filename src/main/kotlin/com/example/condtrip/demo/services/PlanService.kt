package com.example.condtrip.demo.services

import com.example.condtrip.demo.entity.Plan
import com.example.condtrip.demo.repository.PlanRepository
import org.springframework.stereotype.Service

@Service
class PlanService(private val repo: PlanRepository) {
    fun getAll(): List<Plan> = repo.findAll()
    fun getById(id: Int): Plan? = repo.findById(id).orElse(null)
    fun save(data: Plan): Plan = repo.save(data)
    fun delete(id: Int) = repo.deleteById(id)
}