package gentjanahani.u7_l5.payloads;

import java.time.LocalDate;
import java.util.UUID;

public record EventoResponseDTO(
        String titolo,
        String descrizione,
        LocalDate data,
        String luogo,
        long postiDisponibili,
        UUID organizzatore
) {


}
