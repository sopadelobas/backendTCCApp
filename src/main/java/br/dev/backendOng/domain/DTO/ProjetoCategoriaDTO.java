
package br.dev.backendOng.domain.DTO;

import java.util.UUID;


public class ProjetoCategoriaDTO {
    
    private String categoria;
    private UUID projetoId;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public UUID getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(UUID projetoId) {
        this.projetoId = projetoId;
    }
    
    
    
}
