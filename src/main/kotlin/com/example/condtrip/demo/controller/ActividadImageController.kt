// src/main/kotlin/com/example/condtrip/demo/controller/ActividadImageController.kt
package com.example.condtrip.demo.controller

import com.example.condtrip.demo.repository.ActividadRepository
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/actividades")
class ActividadImageController(
    private val actividadRepo: ActividadRepository
) {
    @GetMapping("/{id}/imagen", produces = [MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE])
    fun imagen(@PathVariable id: Int): ResponseEntity<ByteArray> {
        val act = actividadRepo.findById(id).orElseThrow()
        val bytes = act.imagenBytes ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes)
    }
}

