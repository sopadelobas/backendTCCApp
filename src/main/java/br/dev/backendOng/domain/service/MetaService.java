package br.dev.backendOng.domain.service;

import br.dev.backendOng.domain.model.Meta;
import br.dev.backendOng.domain.repository.MetaRepository;
import br.dev.backendOng.exception.DomainException;
import java.math.BigDecimal;
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
        
        if (meta.getQuantidade() == null && meta.getQuantidade().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Quantidade é obrigatória!");
        }
        
        return metaRepository.save(meta);
    }
    
    public void excluirMeta (UUID metaUUID, UUID projetoUUID) {
        Optional<Meta> metaEncontrada = metaRepository.findById(metaUUID);
        
        if (!metaRepository.existsById(metaUUID) || !metaEncontrada.get().getProjeto().getId().equals(projetoUUID)) {
            throw new DomainException("A meta não existe");
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
