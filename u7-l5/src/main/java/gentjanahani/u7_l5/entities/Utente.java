package gentjanahani.u7_l5.entities;

import gentjanahani.u7_l5.ruolo.Ruolo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "utente")
@Getter
@Setter
@NoArgsConstructor
public class Utente implements UserDetails {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID idUtente;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Ruolo ruolo;
    //relazione oneToMany con evento
    @OneToMany(mappedBy = "organizzatore")
    private List<Evento> eventiOrganizzati;
    
    //relazione oneToMany con prenotazioni
    @OneToMany(mappedBy = "utente")
    private List<Prenotazioni> prenotazioni;

    public Utente(String nome, String cognome, String email, String password, Ruolo ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.ruolo = ruolo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.ruolo.name()));
    }

    @Override
    public String getUsername() {
        return "";
    }
}
