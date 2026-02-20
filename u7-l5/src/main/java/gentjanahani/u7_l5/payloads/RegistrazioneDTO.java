package gentjanahani.u7_l5.payloads;

import gentjanahani.u7_l5.ruolo.Ruolo;
import jakarta.validation.constraints.*;

public record RegistrazioneDTO(
        @NotBlank(message = "Il nome è un campo obbligatorio")
        @Size(min = 2, max = 30, message = "Il nome proprio deve essere tra i 2 e i 30 caratteri")
        String nome,
        @NotBlank(message = "Il cognome è un campo obbligatorio")
        @Size(min = 2, max = 30, message = "Il cognome deve essere tra i 2 e i 30 caratteri")
        String cognome,
        @NotBlank(message = "La mail è un campo obbligatorio")
        @Email(message = "L'indirizzo mail fornito non è nel formato corretto")
        String mail,
        @NotBlank(message = "La password è obbligatoria")
        @Size(min = 8, message = "La password deve avere almeno 8 caratteri")
        @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "La password deve contenere una maiuscola, una minuscola e almeno un carattere speciale")
        String password,
        @NotNull
        Ruolo ruolo
) {
}
