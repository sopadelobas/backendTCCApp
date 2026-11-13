/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Uniong.uni.controller;

import Uniong.uni.dto.UsuarioDTO;
import Uniong.uni.dto.UsuarioResponseDTO;
import Uniong.uni.model.Usuario;
import Uniong.uni.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    



@Configuration
public class PasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
    
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarTodos() {
        List<UsuarioResponseDTO> usuarios = usuarioRepository.findAll()
                .stream()
                .map(UsuarioResponseDTO::fromEntity)
                .toList();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .map(u -> ResponseEntity.ok(UsuarioResponseDTO.fromEntity(u)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody UsuarioDTO dto) {
        if (usuarioRepository.existsByCpf(dto.getCpf())) {
            return ResponseEntity.badRequest().body("CPF já cadastrado.");
        }
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            return ResponseEntity.badRequest().body("E-mail já cadastrado.");
        }

        Usuario u = new Usuario();
        u.setNome(dto.getNome());
        u.setCpf(dto.getCpf());
        u.setTelefone(dto.getTelefone());
        u.setAnoNascimento(dto.getAnoNascimento());
        u.setEmail(dto.getEmail());
        u.setSenha(passwordEncoder.encode(dto.getSenha())); // nunca salvar senha pura

        Usuario salvo = usuarioRepository.save(u);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UsuarioResponseDTO.fromEntity(salvo));
    }
}