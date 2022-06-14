package exemplo.teste.spring.projeto.repository;

import exemplo.teste.spring.projeto.domain.Chamada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadaRepository extends JpaRepository<Chamada, Long> {
}
