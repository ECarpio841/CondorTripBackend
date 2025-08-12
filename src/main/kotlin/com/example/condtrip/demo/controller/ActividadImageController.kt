package com.example.condtrip.demo.controller

import com.example.condtrip.demo.repository.ActividadRepository
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/actividades")
class ActividadImagenController(
    private val actividadRepository: ActividadRepository
) {
    // Sirve los bytes de la imagen guardada (si en tu entidad usas imagenBytes: ByteArray?)
    @GetMapping("/{id}/imagen")
    fun getImagen(@PathVariable id: Int): ResponseEntity<ByteArray> {
        val actividad = actividadRepository.findById(id).orElseThrow()
        // Ajusta el campo según tu entidad: imagenBytes o similar.
        // Si todavía usas imagenUrl (String), este endpoint puede ser innecesario.
        val bytes = actividad.imagenBytes ?: ByteArray(0)
        return ResponseEntity.ok()
            .header(HttpHeaders.CACHE_CONTROL, "no-cache")
            .contentType(MediaType.IMAGE_JPEG) // o PNG si corresponde
            .body(bytes)
    }
}
