package gentjanahani.u7_l5.payloads;

import java.util.UUID;

public record PrenotazioniDTO(
        UUID idEvento,
        int posti
) {
}
