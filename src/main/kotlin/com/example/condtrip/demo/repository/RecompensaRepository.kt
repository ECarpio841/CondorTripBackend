package com.example.condtrip.demo.repository

import com.example.condtrip.demo.entity.Recompensa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RecompensaRepository : JpaRepository<Recompensa, Int>