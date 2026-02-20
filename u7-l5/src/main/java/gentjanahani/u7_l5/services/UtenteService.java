package gentjanahani.u7_l5.services;

import gentjanahani.u7_l5.entities.Utente;
import gentjanahani.u7_l5.exceptions.NotFoundException;
import gentjanahani.u7_l5.repository.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UtenteService {

    private final UtenteRepository utenteRepository;

    @Autowired
    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public Utente findUtenteById(UUID idUtente) {
        Utente utente = utenteRepository.findByIdUtente(idUtente);
        if (utente == null) throw new NotFoundException("utente con id: " + idUtente + " non trovato.");
        return utente;
    }
}
