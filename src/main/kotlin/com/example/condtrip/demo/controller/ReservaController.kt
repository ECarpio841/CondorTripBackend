package com.example.condtrip.demo.controller

import com.example.condtrip.demo.dto.ReservaDTO
import com.example.condtrip.demo.entity.Reserva
import com.example.condtrip.demo.repository.ActividadRepository
import com.example.condtrip.demo.repository.UsuarioRepository
import com.example.condtrip.demo.services.ReservaService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/reservas")
class ReservaController(
    private val reservaService: ReservaService,
    private val usuarioRepository: UsuarioRepository,
    private val actividadRepository: ActividadRepository
) {
    @PostMapping
    fun create(@RequestBody dto: ReservaDTO): Reserva {
        val usuario = usuarioRepository.findById(dto.usuarioId).orElseThrow()
        val actividad = actividadRepository.findById(dto.actividadId).orElseThrow()
        val reserva = Reserva(
            usuario = usuario,
            actividad = actividad,
            fechaReserva = dto.fechaReserva,
            cantidadPersonas = dto.cantidadPersonas,
            estado = dto.estado
        )
        return reservaService.save(reserva)
    }
}