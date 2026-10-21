
package br.dev.backendOng.domain.repository;
import br.dev.backendOng.domain.model.Projeto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProjetoRepository extends JpaRepository<Projeto, UUID>{
    List<Projeto> findByCategoria_Id(UUID id);
}
