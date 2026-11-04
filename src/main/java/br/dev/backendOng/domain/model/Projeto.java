
package br.dev.backendOng.domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "projeto")
public class Projeto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    
    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Meta> metas = new ArrayList<>(); 

    public List<Meta> getMetas() {
        return metas;
    }

    public void setMetas(List<Meta> metas) {
        this.metas = metas;
    }
    
    @Column(name = "data_abertura")
    private LocalDate dataAbertura;
    
    @Column(name = "prazo")
    private LocalDateTime prazo;
    
    @Column(name = "doacao_recebida")
    private DoacaoRecebida doacaoRecebida;
    
    @Column(name = "descricao")
    private String descricao;
    
    @JoinColumn(name = "categoria_id")
    @ManyToOne
    @NotNull
    private Categoria categoria;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Projeto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

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

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Projeto other = (Projeto) obj;
        return Objects.equals(this.id, other.id);
    }

    public Projeto(UUID id, LocalDate dataAbertura, LocalDateTime prazo, DoacaoRecebida doacaoRecebida, String descricao, Categoria categoria) {
        this.id = id;
        this.dataAbertura = dataAbertura;
        this.prazo = prazo;
        this.doacaoRecebida = doacaoRecebida;
        this.descricao = descricao;
        this.categoria = categoria;
    }

}
