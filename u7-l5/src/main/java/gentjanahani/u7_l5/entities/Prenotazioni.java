package gentjanahani.u7_l5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    //relazione manyToOne con utente
    @ManyToOne
    @JoinColumn(name = "idUtente")
    private Utente utente;

    //relazione manyToOne con evento
    @ManyToOne
    @JoinColumn(name = "idEvento")
    private Evento evento;
}
