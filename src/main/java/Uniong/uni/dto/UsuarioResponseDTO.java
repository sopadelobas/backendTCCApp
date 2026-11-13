/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Uniong.uni.dto;

import Uniong.uni.model.Usuario;

public record UsuarioResponseDTO(Long id, String nome, String cpf, String telefone,
                                 Integer anoNascimento, String email) {

    public static UsuarioResponseDTO fromEntity(Usuario u) {
        return new UsuarioResponseDTO(u.getId(), u.getNome(), u.getCpf(),
                u.getTelefone(), u.getAnoNascimento(), u.getEmail());
    }
}