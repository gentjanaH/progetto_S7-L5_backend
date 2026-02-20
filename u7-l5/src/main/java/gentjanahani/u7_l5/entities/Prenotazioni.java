package gentjanahani.u7_l5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prenotazioni")
@Getter
@Setter
@NoArgsConstructor
public class Prenotazioni {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID idPrenotazione;
    private int numeroPosti;
    LocalDate dataPrenotazione;

    //relazione manyToOne con utente
    @ManyToOne
    @JoinColumn(name = "idUtente")
    private Utente utente;

    //relazione manyToOne con evento
    @ManyToOne
    @JoinColumn(name = "idEvento")
    private Evento evento;

    public Prenotazioni(int numeroPosti, LocalDate dataPrenotazione, Utente utente, Evento evento) {
        this.numeroPosti = numeroPosti;
        this.dataPrenotazione = dataPrenotazione;
        this.utente = utente;
        this.evento = evento;
    }
}
