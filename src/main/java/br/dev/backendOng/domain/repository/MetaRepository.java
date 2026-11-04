
package br.dev.backendOng.domain.repository;

import br.dev.backendOng.domain.model.Meta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface MetaRepository extends JpaRepository<Meta, UUID>{

}
