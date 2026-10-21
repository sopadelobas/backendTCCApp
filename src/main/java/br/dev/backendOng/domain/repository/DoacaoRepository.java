/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package br.dev.backendOng.domain.repository;

import br.dev.backendOng.domain.model.Doacao;
import br.dev.backendOng.domain.model.Meta;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoacaoRepository extends JpaRepository<Doacao, UUID> {
  List<Meta> findbyId(UUID id);
}
