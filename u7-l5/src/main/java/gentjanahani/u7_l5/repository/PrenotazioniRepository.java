package gentjanahani.u7_l5.repository;

import gentjanahani.u7_l5.entities.Prenotazioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazioni, UUID> {

    Prenotazioni findByIdPrenotazione(UUID idPrenotazione);

}
