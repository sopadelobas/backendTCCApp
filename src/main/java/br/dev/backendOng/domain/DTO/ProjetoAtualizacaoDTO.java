
package br.dev.backendOng.domain.DTO;

import br.dev.backendOng.domain.model.DoacaoRecebida;
import java.time.LocalDateTime;

public class ProjetoAtualizacaoDTO {
    
    private LocalDateTime prazo;
    private DoacaoRecebida doacaoRecebida;
    private String descricao;

    public LocalDateTime getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDateTime prazo) {
        this.prazo = prazo;
    }

    public DoacaoRecebida getDoacaoRecebida() {
        return doacaoRecebida;
    }

    public void setDoacaoRecebida(DoacaoRecebida doacaoRecebida) {
        this.doacaoRecebida = doacaoRecebida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
   
}
