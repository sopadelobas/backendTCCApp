package br.dev.backendOng.domain.service;

import br.dev.backendOng.domain.model.Meta;
import br.dev.backendOng.domain.repository.MetaRepository;
import br.dev.backendOng.exception.DomainException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetaService {

    
    @Autowired
    private MetaRepository metaRepository;
    
    public Meta criar (Meta meta) {
        
        if (meta.getQuantidade() == null) {
            throw new RuntimeException("Quantidade é obrigatória!");
        }
        
        return metaRepository.save(meta);
    }
    
    public void excluirMeta (UUID metaUUID) {
        if (!metaRepository.existsById(metaUUID)) {
            throw new DomainException("A doação não existe");
        }
        metaRepository.deleteById(metaUUID);
    }
    
    public List<Meta> listar() {
        return metaRepository.findAll();
    }
    
    public Optional<Meta> listarMetaPorId (UUID metaID) {
        return metaRepository.findById(metaID);
    }
}
