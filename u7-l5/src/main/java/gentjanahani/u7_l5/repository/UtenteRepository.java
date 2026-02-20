package gentjanahani.u7_l5.repository;

import gentjanahani.u7_l5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, UUID> {

    Utente findByIdUtente(UUID idUtente);


    Optional<Utente> findByEmail(String email);
}
