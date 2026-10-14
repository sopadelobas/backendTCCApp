/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package br.dev.backendOng.domain.controller;

import br.dev.backendOng.domain.model.Projeto;
import br.dev.backendOng.domain.repository.MetaRepository;
import br.dev.backendOng.domain.repository.ProjetoRepository;
import br.dev.backendOng.domain.service.ProjetoService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



public class ProjetoController {

@Autowired
 private ProjetoService projetoService;

@Autowired
 private ProjetoRepository projetoRepository;

@Autowired
 private MetaRepository metaRepository;

 @PostMapping
 public Projeto criar(@RequestBody Projeto projeto) {
     return projetoService.criar(projeto);
 }
 @DeleteMapping
 public ResponseEntity<Void> excluir(@PathVariable UUID projetoUUID) {
     if (!projetoRepository.existsById(projetoUUID)) {
         return ResponseEntity.notFound().build();
     }
     
     projetoService.excluir(projetoUUID);
     return ResponseEntity.noContent().build();
 }

}
