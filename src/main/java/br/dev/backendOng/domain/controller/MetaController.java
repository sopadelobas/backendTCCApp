
package br.dev.backendOng.domain.controller;

import br.dev.backendOng.domain.model.Meta;
import br.dev.backendOng.domain.repository.MetaRepository;
import br.dev.backendOng.domain.service.MetaService;
import java.util.List;
import java.util.Optional;
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

@RestController
@RequestMapping("/metas")
public class MetaController {

    @Autowired
    private MetaService metaService;
    
    @Autowired
    private MetaRepository metaRepository;
    
    @PostMapping
    public Meta criarMeta(@RequestBody Meta meta) {
        return metaService.criar(meta);
    }
    
    @DeleteMapping("/{projetoUUID}/{metaUUID}") 
    public ResponseEntity<Void> excluirMeta(@PathVariable UUID metaUUID) {
       metaService.excluirMeta(metaUUID);
       return ResponseEntity.noContent().build();
    }
    
    @GetMapping
    public List<Meta> listarTodos() {
        List<Meta> listaMetas = metaService.listar();
        return listaMetas;
    }
    
    @GetMapping ("/{projetoUUID}/{metaUUID}")  
    public ResponseEntity<Meta> listarPorId(@PathVariable UUID metaUUID) {
        Optional<Meta> meta = metaService.listarMetaPorId(metaUUID);
        
        if (meta.isPresent()) {
            return ResponseEntity.ok(meta.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{projetoUUID}/{metaUUID}") 
    public ResponseEntity<UUID> atualizarMeta (@PathVariable UUID metaUUID, @RequestBody Meta metaAtualizada) {
        Optional<Meta> metaAnt = metaService.listarMetaPorId(metaUUID);
        
        if (metaAnt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        Meta meta = metaAnt.get();
        meta.setQuantidade(metaAtualizada.getQuantidade());
        
        metaRepository.save(meta);
        return ResponseEntity.ok(metaUUID);
    }
}
    