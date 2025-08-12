// com/example/condtrip/demo/controller/PuntosController.kt
package com.example.condtrip.demo.controller

import com.example.condtrip.demo.entity.RecompensaClaim
import com.example.condtrip.demo.repository.RecompensaClaimRepository
import com.example.condtrip.demo.repository.RecompensaRepository
import com.example.condtrip.demo.repository.UsuarioRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/puntos")
class PuntosController(
    private val usuarioRepo: UsuarioRepository,
    private val recompensaRepo: RecompensaRepository,
    private val claimRepo: RecompensaClaimRepository
) {
    data class ClaimRequest(val usuarioId: Int)

    @GetMapping("/{usuarioId}")
    fun puntos(@PathVariable usuarioId: Int) =
        usuarioRepo.findById(usuarioId).orElseThrow().puntos

    @GetMapping("/recompensas")
    fun listarRecompensas() = recompensaRepo.findAll()

    @PostMapping("/recompensas/{recompensaId}/claim")
    fun claim(@PathVariable recompensaId: Int, @RequestBody body: ClaimRequest): ResponseEntity<Any> {
        val user = usuarioRepo.findById(body.usuarioId).orElseThrow()
        val rec = recompensaRepo.findById(recompensaId).orElseThrow()

        if (user.puntos < rec.puntosNecesarios) {
            return ResponseEntity.badRequest().body(mapOf("message" to "Puntos insuficientes"))
        }

        user.puntos -= rec.puntosNecesarios
        usuarioRepo.save(user)
        claimRepo.save(RecompensaClaim(usuario = user, recompensa = rec))

        return ResponseEntity.ok(mapOf("ok" to true))
    }
}
