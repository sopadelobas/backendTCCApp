package br.dev.backendOng.domain.controller;

import br.dev.backendOng.domain.model.Doacao;
import br.dev.backendOng.domain.repository.DoacaoRepository;
import br.dev.backendOng.domain.service.DoacaoService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doacao")
public class DoacaoController {
 
    @Autowired
    private DoacaoService doacaoService;
    
    @Autowired
    private DoacaoRepository doacaoRepository;
    
    @PostMapping
    public ResponseEntity<Doacao> criar(@RequestBody Doacao doacao) {
        Doacao doacaoNova = doacaoService.criar(doacao);
        return ResponseEntity.ok(doacaoNova);
    }
    
    @DeleteMapping ("{doacaoUUID}")
    public ResponseEntity<Void> excluir (@PathVariable UUID doacaoUUID) {
        
        doacaoService.excluir(doacaoUUID);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping 
    public List<Doacao> listarDoacoes() {
        return doacaoService.gerarHistorico();
    }
    
    @GetMapping ("{doacaoUUID}")
    public ResponseEntity<Doacao> listarPorId(@PathVariable UUID doacaoUUID) {
        Optional<Doacao> doacao = doacaoService.listarPorId(doacaoUUID);
        
        if(doacao.isPresent()) {
            return ResponseEntity.ok(doacao.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
