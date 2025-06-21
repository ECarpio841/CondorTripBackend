package com.example.condtrip.demo.repository

import com.example.condtrip.demo.entity.PlanItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlanItemRepository : JpaRepository<PlanItem, Int>