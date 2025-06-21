package com.example.condtrip.demo.repository

import com.example.condtrip.demo.entity.RespuestaFiltro
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RespuestaFiltroRepository : JpaRepository<RespuestaFiltro, Int>