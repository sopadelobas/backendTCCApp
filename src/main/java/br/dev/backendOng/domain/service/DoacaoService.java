
package br.dev.backendOng.domain.service;

import br.dev.backendOng.domain.model.Doacao;
import br.dev.backendOng.domain.repository.DoacaoRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;


public class DoacaoService {
   
    @Autowired
    private DoacaoRepository doacaoRepository;
    
    public Doacao realizarDoacao (Doacao doacao) {
        if(doacao.getValor() == null || doacao.getValor().isEmpty()) {
            throw new RuntimeException("Valor é obrigatório!");
        }
        
       return doacaoRepository.save(doacao);
        
    }
    
    public void excluir (UUID doacaoUUID) {
        doacaoRepository.deleteById(doacaoUUID);
    }
    
    public List<Doacao> gerarHistorico () {
        return doacaoRepository.findAll();
    }
    
    public Optional<Doacao> listarPorId(UUID doacaoUUID) {
        return doacaoRepository.findById(doacaoUUID);
    }
    
}
