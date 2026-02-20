package gentjanahani.u7_l5.services;

import gentjanahani.u7_l5.entities.Evento;
import gentjanahani.u7_l5.entities.Prenotazioni;
import gentjanahani.u7_l5.entities.Utente;
import gentjanahani.u7_l5.exceptions.BadRequestException;
import gentjanahani.u7_l5.exceptions.NotFoundException;
import gentjanahani.u7_l5.payloads.EventoResponseDTO;
import gentjanahani.u7_l5.payloads.PrenotazioneResponseDTO;
import gentjanahani.u7_l5.payloads.PrenotazioniDTO;
import gentjanahani.u7_l5.repository.PrenotazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {

    private final PrenotazioniRepository prenotazioniRepository;
    private final EventoService eventoService;

    @Autowired
    public PrenotazioneService(PrenotazioniRepository prenotazioniRepository, EventoService eventoService) {
        this.prenotazioniRepository = prenotazioniRepository;
        this.eventoService = eventoService;
    }

    public PrenotazioneResponseDTO save(Utente idUtente, PrenotazioniDTO payload) {

        Evento evento = eventoService.findEvento(payload.idEvento());

        if (evento == null) throw new NotFoundException("evento non trovato");
        if (evento.getPostiDisponibili() < payload.posti())
            throw new BadRequestException("spiacenti, ci sono solo: " + payload.posti() + " disponibili.");

        Prenotazioni prenotazione=new Prenotazioni();
        prenotazione.setEvento(evento);
        prenotazione.setUtente(idUtente);
        prenotazione.setNumeroPosti(payload.posti());
        prenotazione.
    }
}
