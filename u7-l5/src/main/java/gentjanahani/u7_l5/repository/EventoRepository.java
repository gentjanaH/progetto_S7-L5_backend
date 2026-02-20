package gentjanahani.u7_l5.repository;

import gentjanahani.u7_l5.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventoRepository extends JpaRepository<Evento, UUID> {

    Evento findByIdEvento(UUID idEvento);


}
