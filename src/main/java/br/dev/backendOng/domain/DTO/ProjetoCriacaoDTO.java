package br.dev.backendOng.domain.DTO;

import br.dev.backendOng.domain.model.DoacaoRecebida;
import br.dev.backendOng.domain.model.Meta;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ProjetoCriacaoDTO {

    private LocalDate dataAbertura;
    private LocalDateTime prazo;
    private DoacaoRecebida doacaoRecebida;
    private String descricao;
    private UUID categoriaId;
    private Meta meta;

    public ProjetoCriacaoDTO() {
    }

    public ProjetoCriacaoDTO(LocalDateTime prazo, DoacaoRecebida doacaoRecebida, String descricao, UUID categoriaId) {
        this.prazo = prazo;
        this.doacaoRecebida = doacaoRecebida;
        this.descricao = descricao;
        this.categoriaId = categoriaId;
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

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public UUID getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(UUID categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
