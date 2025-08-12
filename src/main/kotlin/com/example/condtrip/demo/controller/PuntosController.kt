// src/main/kotlin/com/example/condtrip/demo/controller/PuntosController.kt
package com.example.condtrip.demo.controller

import com.example.condtrip.demo.entity.Recompensa
import com.example.condtrip.demo.entity.RecompensaClaim
import com.example.condtrip.demo.repository.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class PuntosController(
    private val usuarioRepo: UsuarioRepository,
    private val recompensaRepo: RecompensaRepository,
    private val actividadRepo: ActividadRepository,
    private val claimRepo: RecompensaClaimRepository,
    private val notifRepo: NotificacionNegocioRepository
) {
    data class Puntos(val puntos: Int)
    data class ClaimRequest(val usuarioId: Int)
    data class CrearRecompensaDTO(
        val actividadId: Int,
        val nombre: String,
        val descripcion: String,
        val puntosNecesarios: Int
    )

    @GetMapping("/puntos/{usuarioId}")
    fun puntos(@PathVariable usuarioId: Int) =
        Puntos(usuarioRepo.findById(usuarioId).orElseThrow().puntos ?: 0)

    @GetMapping("/puntos/recompensas")
    fun listarRecompensas(): List<Recompensa> = recompensaRepo.findAll()

    @PostMapping("/puntos/recompensas/{recompensaId}/claim")
    fun claim(@PathVariable recompensaId: Int, @RequestBody body: ClaimRequest): ResponseEntity<Any> {
        val user = usuarioRepo.findById(body.usuarioId).orElseThrow()
        val rec = recompensaRepo.findById(recompensaId).orElseThrow()

        val disponibles = user.puntos ?: 0
        if (disponibles < rec.puntosNecesarios) {
            return ResponseEntity.badRequest().body(mapOf("message" to "Puntos insuficientes"))
        }

        // RESTA puntos (mutamos propiedad del objeto; no reasignamos una 'val')
        user.puntos = disponibles - rec.puntosNecesarios
        usuarioRepo.save(user)

        // Guardar claim como entidad JPA "normal"
        val claim = RecompensaClaim().apply {
            this.usuario = user
            this.recompensa = rec
            this.fecha = Date()
        }
        claimRepo.save(claim)

        // Notificar al negocio (planId puede ser null; si tu columna es NOT NULL, cámbiala a nullable o envía 0)
        val duenio = rec.restaurante?.usuario
        if (duenio != null) {
            notifRepo.save(
                com.example.condtrip.demo.entity.NotificacionNegocio(
                    usuario = duenio,
                    actividad = rec.restaurante,
                    planId = null,                 // <-- si tu schema NO permite null, usa 0 o hazla nullable en la entidad/DDL
                    titulo = "Recompensa reclamada",
                    mensaje = "${user.nombre ?: "Un usuario"} reclamó '${rec.nombre}'.",
                    fecha = Date(),
                    leido = false
                )
            )
        }

        return ResponseEntity.ok(mapOf("ok" to true))
    }

    @PostMapping("/recompensas/negocio")
    fun crearRecompensa(@RequestBody dto: CrearRecompensaDTO): Recompensa {
        val act = actividadRepo.findById(dto.actividadId).orElseThrow()
        return recompensaRepo.save(
            Recompensa(
                restaurante = act,
                nombre = dto.nombre,
                descripcion = dto.descripcion,
                puntosNecesarios = dto.puntosNecesarios
            )
        )
    }
}
