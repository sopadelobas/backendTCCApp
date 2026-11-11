package br.dev.backendOng.domain.service;

import br.dev.backendOng.domain.DTO.ProjetoCriacaoDTO;
import br.dev.backendOng.domain.DTO.ProjetoAtualizacaoDTO;
import br.dev.backendOng.domain.model.Categoria;
import br.dev.backendOng.domain.model.Projeto;
import br.dev.backendOng.domain.repository.CategoriaRepository;
import br.dev.backendOng.domain.repository.ProjetoRepository;
import br.dev.backendOng.exception.DomainException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Projeto criar(ProjetoCriacaoDTO dto) {

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId()).orElseThrow(() -> new DomainException("Categoria não encontrada"));

        Projeto projeto = new Projeto();

        projeto.setDataAbertura(LocalDate.now());
        projeto.setPrazo(dto.getPrazo());
        projeto.setDoacaoRecebida(dto.getDoacaoRecebida());
        projeto.setCategoria(categoria);

        return projetoRepository.save(projeto);
    }

    public void excluir(UUID projetoUUID) {
        if (!projetoRepository.existsById(projetoUUID)) {
            throw new DomainException("A doação não existe");
        }
        projetoRepository.deleteById(projetoUUID);
    }

    public List<Projeto> listarTodos() {
        return projetoRepository.findAll();
    }

    public Optional<Projeto> listarPorId(UUID projetoID) {
        return projetoRepository.findById(projetoID);
    }

    public ResponseEntity<Projeto> atualizar(UUID projetoID, ProjetoAtualizacaoDTO dto) {
        Optional<Projeto> projetoAnt = projetoRepository.findById(projetoID);

        if (projetoAnt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Projeto projeto = projetoAnt.get();
        projeto.setPrazo(dto.getPrazo());
        projeto.setDoacaoRecebida(dto.getDoacaoRecebida());
        projeto.setDescricao(dto.getDescricao());

        return projetoRepository.save(projeto);
    }

    public List<Projeto> listarPorCategoria(UUID categoriaId) {
        return projetoRepository.findByCategoria_Id(categoriaId);
    }

}
