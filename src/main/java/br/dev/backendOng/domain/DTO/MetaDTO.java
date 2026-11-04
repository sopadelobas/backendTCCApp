
package br.dev.backendOng.domain.DTO;

import br.dev.backendOng.domain.model.Projeto;
import java.math.BigDecimal;
import java.util.UUID;

public class MetaDTO {
    
    private UUID id;
    private BigDecimal quantidade;
    private Projeto projeto;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    
    
    public MetaDTO(UUID id, BigDecimal quantidade, Projeto projeto) {
        this.id = id;
        this.quantidade = quantidade;
        this.projeto = projeto;
    }

    public MetaDTO() {
    }
}
