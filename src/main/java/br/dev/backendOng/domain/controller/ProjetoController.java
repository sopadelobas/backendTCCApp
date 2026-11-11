
package br.dev.backendOng.domain.controller;

import br.dev.backendOng.domain.DTO.ProjetoAtualizacaoDTO;
import br.dev.backendOng.domain.DTO.ProjetoCriacaoDTO;
import br.dev.backendOng.domain.model.Projeto;
import br.dev.backendOng.domain.repository.ProjetoRepository;
import br.dev.backendOng.domain.service.ProjetoService;
import br.dev.backendOng.exception.DomainException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private ProjetoRepository projetoRepository;

    @PostMapping
    public Projeto criar(@RequestBody ProjetoCriacaoDTO projetoDTO) {
        return projetoService.criar(projetoDTO);
    }

    @DeleteMapping("{projetoUUID}")
    
    public ResponseEntity<Void> excluir(@PathVariable UUID projetoUUID) {
        projetoService.excluir(projetoUUID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Projeto> listarTodos() {
        List<Projeto> listaProjetos = projetoService.listarTodos();
        return listaProjetos;
    }

    @GetMapping("{projetoUUID}")
    public ResponseEntity<Projeto> listarPorId(@PathVariable UUID projetoUUID) {
        Optional<Projeto> projeto = projetoService.listarPorId(projetoUUID);

        if (projeto.isPresent()) {
            return ResponseEntity.ok(projeto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("cat/{categoriaUUID}")
    public List<Projeto> listarPorCategoria(@PathVariable UUID categoriaUUID) {
        List<Projeto> listaCat = projetoService.listarPorCategoria(categoriaUUID);

        if (listaCat.isEmpty()) {
            throw new DomainException("Nenhum projeto encontrado para essa categoria");
        }

        return listaCat;
    }

    @PutMapping("{projetoID}")
     public ResponseEntity<Projeto>(@PathVariable UUID projetoID, @RequestBody ProjetoAtualizacaoDTO projetoDTO) {
        return projetoRepository.save(projetoDTO);
    }
}
