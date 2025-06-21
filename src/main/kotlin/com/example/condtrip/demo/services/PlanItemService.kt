package com.example.condtrip.demo.services

import com.example.condtrip.demo.entity.PlanItem
import com.example.condtrip.demo.repository.PlanItemRepository
import org.springframework.stereotype.Service

@Service
class PlanItemService(private val repo: PlanItemRepository) {
    fun getAll(): List<PlanItem> = repo.findAll()
    fun getById(id: Int): PlanItem? = repo.findById(id).orElse(null)
    fun save(data: PlanItem): PlanItem = repo.save(data)
    fun delete(id: Int) = repo.deleteById(id)
}