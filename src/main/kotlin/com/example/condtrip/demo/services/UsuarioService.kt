package com.example.condtrip.demo.services
import com.example.condtrip.demo.entity.Usuario
import com.example.condtrip.demo.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val usuarioRepository: UsuarioRepository) {
    fun getAll(): List<Usuario> = usuarioRepository.findAll()
    fun getById(id: Int): Usuario? = usuarioRepository.findById(id).orElse(null)
    fun save(usuario: Usuario): Usuario = usuarioRepository.save(usuario)
    fun delete(id: Int) = usuarioRepository.deleteById(id)
}
