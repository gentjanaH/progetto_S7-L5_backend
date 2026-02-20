package gentjanahani.u7_l5.services;

import gentjanahani.u7_l5.entities.Utente;
import gentjanahani.u7_l5.exceptions.BadRequestException;
import gentjanahani.u7_l5.exceptions.NotFoundException;
import gentjanahani.u7_l5.payloads.RegistrazioneDTO;
import gentjanahani.u7_l5.repository.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UtenteService {

    private final UtenteRepository utenteRepository;
    private final PasswordEncoder bcrypt;

    @Autowired
    public UtenteService(UtenteRepository utenteRepository, PasswordEncoder bcrypt) {
        this.utenteRepository = utenteRepository;
        this.bcrypt = bcrypt;
    }

    public Utente findUtenteById(UUID idUtente) {
        Utente utente = utenteRepository.
                findByIdUtente(idUtente);
        if (utente == null) throw new NotFoundException("utente con id: " + idUtente + " non trovato.");
        return utente;
    }

    public Utente save(RegistrazioneDTO payload) {
        this.utenteRepository.findByEmail(payload.mail()).ifPresent(utente -> {
            throw new BadRequestException("L'email inserita è gia in uso");
        });

        Utente utente = new Utente(payload.nome(), payload.cognome(), payload.mail(), bcrypt.encode(payload.password()), payload.ruolo());
        Utente saveUtente = this.utenteRepository.save(utente);
        return saveUtente;
    }

}
