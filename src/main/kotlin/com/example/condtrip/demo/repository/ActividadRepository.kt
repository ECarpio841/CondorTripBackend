package com.example.condtrip.demo.repository

import com.example.condtrip.demo.entity.Actividad
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ActividadRepository : JpaRepository<Actividad, Int>