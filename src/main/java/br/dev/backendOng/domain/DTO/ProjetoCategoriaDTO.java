
package br.dev.backendOng.domain.DTO;

import br.dev.backendOng.domain.model.Categoria;
import java.util.UUID;


public class ProjetoCategoriaDTO {
    
    private Categoria categoria;
    private UUID projetoId;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public UUID getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(UUID projetoId) {
        this.projetoId = projetoId;
    }
    
    
    
}
