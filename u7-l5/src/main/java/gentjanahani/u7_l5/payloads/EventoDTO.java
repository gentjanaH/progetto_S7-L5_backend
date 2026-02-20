package gentjanahani.u7_l5.payloads;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

public record EventoDTO(
        @NotBlank(message = "Il titolo dell'evento è un campo obbligatorio")
        @Size(min = 2, max = 30, message = "Il titolo deve essere tra i 2 e i 30 caratteri")
        String titolo,
        @NotBlank(message = "Il titolo dell'evento è un campo obbligatorio")
        @Size(min = 2, max = 30, message = "Il titolo deve essere tra i 2 e i 100 caratteri")
        String descrizione,
        @NotNull
        @JsonFormat(pattern = "yyyy-MM-dd")
        @FutureOrPresent(message = "La data dell'evento deve essere nel futuro")
        LocalDate data,
        @NotBlank(message = "Il luogo dell'evento è un campo obbligatorio")
        @Size(min = 2, max = 30, message = "Il luogo deve essere tra i 2 e i 30 caratteri")
        String luogo,
        @Min(value = 1, message = "1 è il valore minimo per i posti disponibili")
        long postiDisponibili
) {
}
