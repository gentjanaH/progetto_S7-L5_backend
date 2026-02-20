package gentjanahani.u7_l5.payloads;

import java.time.LocalDate;
import java.util.UUID;

public record PrenotazioneResponseDTO(
        UUID idPrenotazione,
        UUID idEvento,
        UUID idUtente,
        int posti,
        LocalDate dataPrenotazione
) {
}
