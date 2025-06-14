package com.example.condtrip.demo.repository

import com.example.condtrip.demo.entity.Alerta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AlertaRepository : JpaRepository<Alerta, Int>