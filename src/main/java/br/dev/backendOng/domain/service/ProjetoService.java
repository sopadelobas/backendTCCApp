package br.dev.backendOng.domain.service;

import br.dev.backendOng.domain.model.Projeto;
import br.dev.backendOng.domain.repository.ProjetoRepository;
import br.dev.backendOng.exception.DomainException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public Projeto criar(Projeto projeto) {
        projeto.setDataAbertura(LocalDate.now());
        projeto.setMeta(projeto.getMeta());
        projeto.setPrazo(projeto.getPrazo());
        projeto.setDoacaoRecebida(projeto.getDoacaoRecebida());

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

    public Projeto atualizar(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public List<Projeto> listarPorCategoria(UUID categoriaId) {
        return projetoRepository.findByCategoria_Id(categoriaId);
    }

}
