package com.example.condtrip.demo.repository

import com.example.condtrip.demo.entity.Reserva
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ReservaRepository : JpaRepository<Reserva, Int>