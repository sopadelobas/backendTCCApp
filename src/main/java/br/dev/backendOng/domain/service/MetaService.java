package br.dev.backendOng.domain.service;

import br.dev.backendOng.domain.model.Meta;
import br.dev.backendOng.domain.repository.MetaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

public class MetaService {

    
    @Autowired
    private MetaRepository metaRepository;
    
    public Meta criar (Meta meta) {
        
        if (meta.getQuantidade() == null) {
            throw new RuntimeException("Quantidade é obrigatória!");
        }
        
        return metaRepository.save(meta);
    }
    
    public void excluirMeta (UUID metaID) {
        metaRepository.deleteById(metaID);
    }
    
    public List<Meta> listar() {
        return metaRepository.findAll();
    }
    
    public Optional<Meta> listarMetaPorId (UUID metaID) {
        return metaRepository.findById(metaID);
    }
}
