package gentjanahani.u7_l5.controllers;

import gentjanahani.u7_l5.entities.Utente;
import gentjanahani.u7_l5.exceptions.ValidationException;
import gentjanahani.u7_l5.payloads.RegistrazioneDTO;
import gentjanahani.u7_l5.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {
    private final UtenteService utenteService;

    @Autowired
    public AuthorizationController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    // 1. POST http://localhost:3026/auth/subscribe (+ Payload)
    @PostMapping("/subscribe")
    @ResponseStatus(HttpStatus.CREATED)
    public Utente createAccount(@RequestBody @Validated RegistrazioneDTO payload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            List<String> errorsList = validationResult.getFieldErrors()
                    .stream()
                    .map(fieldError -> fieldError.getDefaultMessage())
                    .toList();

            throw new ValidationException(errorsList);
        } else {
            return this.utenteService.save(payload);
        }
    }
}
