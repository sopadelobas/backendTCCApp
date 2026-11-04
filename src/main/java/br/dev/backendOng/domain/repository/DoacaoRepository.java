
package br.dev.backendOng.domain.repository;

import br.dev.backendOng.domain.model.Doacao;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoacaoRepository extends JpaRepository<Doacao, UUID> {
}
