package com.example.condtrip.demo.repository

import com.example.condtrip.demo.entity.Plan
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlanRepository : JpaRepository<Plan, Int>