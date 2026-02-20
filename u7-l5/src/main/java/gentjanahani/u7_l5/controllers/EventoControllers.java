package gentjanahani.u7_l5.controllers;

import gentjanahani.u7_l5.entities.Evento;
import gentjanahani.u7_l5.entities.Utente;
import gentjanahani.u7_l5.payloads.EventoDTO;
import gentjanahani.u7_l5.payloads.EventoResponseDTO;
import gentjanahani.u7_l5.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/event")
public class EventoControllers {
    private final EventoService eventoService;

    @Autowired
    public EventoControllers(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    // 1. POST http://localhost:3026/event (+ Payload)
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")
    @PostMapping
    public EventoResponseDTO saveEvento(@AuthenticationPrincipal Utente organizzatore, @RequestBody @Validated EventoDTO payload) {
        return this.eventoService.save(organizzatore, payload);
    }


    //2. DELETE http://localhost:3026/event/{idEvento}
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")
    @DeleteMapping("/{idEvento}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@AuthenticationPrincipal Utente organizzatore, @PathVariable UUID idEvento) {
        this.eventoService.findAndDelete(organizzatore, idEvento);
    }
}
