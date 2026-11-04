
package br.dev.backendOng.domain.repository;

import br.dev.backendOng.domain.model.Categoria;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID>{

}
