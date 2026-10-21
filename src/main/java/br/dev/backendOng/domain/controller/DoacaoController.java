package br.dev.backendOng.domain.controller;

import br.dev.backendOng.domain.model.Doacao;
import br.dev.backendOng.domain.repository.DoacaoRepository;
import br.dev.backendOng.domain.service.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class DoacaoController {
 
    @Autowired
    private DoacaoService doacaoService;
    
    @Autowired
    private DoacaoRepository doacaoRepository;
    
    @PostMapping
    public Doacao criar(@RequestBody Doacao doacao) {
        return doacaoService.criar(doacao);
    }
    
}
