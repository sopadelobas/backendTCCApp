
package br.dev.backendOng.domain.DTO;

import br.dev.backendOng.domain.model.Meta;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProjetoDTO {
    
    private Meta meta; 

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public LocalDateTime getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDateTime prazo) {
        this.prazo = prazo;
    }

    public String getDoacaoRecebida() {
        return doacaoRecebida;
    }

    public void setDoacaoRecebida(String doacaoRecebida) {
        this.doacaoRecebida = doacaoRecebida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    private LocalDateTime prazo;
    private String doacaoRecebida;
    private String descricao;
}
