package gentjanahani.u7_l5.services;

import gentjanahani.u7_l5.entities.Evento;
import gentjanahani.u7_l5.entities.Utente;
import gentjanahani.u7_l5.exceptions.NotFoundException;
import gentjanahani.u7_l5.exceptions.UnautorizedException;
import gentjanahani.u7_l5.payloads.EventoDTO;
import gentjanahani.u7_l5.payloads.EventoResponseDTO;
import gentjanahani.u7_l5.repository.EventoRepository;
import gentjanahani.u7_l5.security.CreateAndVerify;
import gentjanahani.u7_l5.security.SecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;
    private final UtenteService utenteService;
    private final CreateAndVerify createAndVerify;

    @Autowired
    public EventoService(EventoRepository eventoRepository, UtenteService utenteService, CreateAndVerify createAndVerify) {
        this.eventoRepository = eventoRepository;
        this.utenteService = utenteService;
        this.createAndVerify = createAndVerify;
    }

    public EventoResponseDTO save(Utente organizzatore, EventoDTO payload) {

        Evento evento = new Evento(
                payload.titolo(),
                payload.descrizione(),
                payload.data(),
                payload.luogo(),
                payload.postiDisponibili(),
                organizzatore);

        Evento saveEvento = this.eventoRepository.save(evento);

        EventoResponseDTO eventoDefinitivo = new EventoResponseDTO(
                saveEvento.getTitolo(),
                saveEvento.getDescrizione(),
                saveEvento.getData(),
                saveEvento.getLuogo(),
                saveEvento.getPostiDisponibili(),
                saveEvento.getOrganizzatore().getIdUtente());

        return eventoDefinitivo;
    }

    public void findAndDelete(Utente organizzatore, UUID idEvento) {
        Evento evento = eventoRepository.findByIdEvento(idEvento);
        if (evento == null) throw new NotFoundException("evento non trovato");

        if (!evento.getOrganizzatore().getIdUtente().equals(organizzatore.getIdUtente()))
            throw new UnautorizedException("Non sei autorizzato a svolgere questa operazione");

        eventoRepository.delete(evento);
    }
}
