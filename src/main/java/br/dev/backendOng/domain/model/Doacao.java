
package br.dev.backendOng.domain.model;

import jakarta.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Doacao {
    
    private UUID id;
    public BigDecimal valor;
   //Usuario usuarioDoador a ser feito || @ManyToOne
   //Usuario usuarioAjudado a ser feito || @ManyToOne
    public LocalDateTime dataHorario;
    public String localPais;
    
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(LocalDateTime dataHorario) {
        this.dataHorario = dataHorario;
    }

    public String getLocalPais() {
        return localPais;
    }

    public void setLocalPais(String localPais) {
        this.localPais = localPais;
    }
    
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Doacao other = (Doacao) obj;
        return Objects.equals(this.id, other.id);
    }
}
