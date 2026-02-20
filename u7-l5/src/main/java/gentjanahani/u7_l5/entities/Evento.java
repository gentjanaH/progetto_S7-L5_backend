package gentjanahani.u7_l5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "evento")
@Getter
@Setter
@NoArgsConstructor

public class Evento {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID idEvento;
    private String titolo;
    private String descrizione;
    private LocalDate data;
    private String luogo;
    private long postiDisponibili;

    //relazione oneToMany con prenotazioni
    @OneToMany(mappedBy = "evento")
    private List<Prenotazioni> prenotazioni;

    public Evento(String titolo, String descrizione, LocalDate data, String luogo, long postiDisponibili) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.data = data;
        this.luogo = luogo;
        this.postiDisponibili = postiDisponibili;
    }
}
