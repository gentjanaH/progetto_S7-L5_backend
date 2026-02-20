package gentjanahani.u7_l5.services;

import gentjanahani.u7_l5.entities.Utente;
import gentjanahani.u7_l5.exceptions.UnautorizedException;
import gentjanahani.u7_l5.payloads.LoginDTO;
import gentjanahani.u7_l5.security.CreateAndVerify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final UtenteService utenteService;
    private final CreateAndVerify createAndVerify;
    private final PasswordEncoder bcrypt;

    @Autowired
    public AuthorizationService(UtenteService utenteService, CreateAndVerify createAndVerify, PasswordEncoder bcrypt) {
        this.utenteService = utenteService;
        this.createAndVerify = createAndVerify;

        this.bcrypt = bcrypt;
    }

    public String checkAndGenerate(LoginDTO bodyLogin) {
        Utente utente = this.utenteService.findByEmail(bodyLogin.mail());

        if (bcrypt.matches(bodyLogin.password(), utente.getPassword())) {
            String accesToken = createAndVerify.generateToken(utente);

            return accesToken;
        } else {
            throw new UnautorizedException("Credenziali non valide");
        }
    }
}
