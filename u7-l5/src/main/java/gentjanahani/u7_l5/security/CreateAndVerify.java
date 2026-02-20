//package gentjanahani.u7_l5.security;
//
//
//import gentjanahani.u7_l5.entities.Dipendente;
//import gentjanahani.u7_l5.entities.Utente;
//import gentjanahani.u7_l5.exceptions.UnautorizedException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.UUID;
//
//@Component
//public class CreateAndVerify {
//    @Value("${jwt.secret}")
////dopo aver salvato il segreto nel'env.properties e averlo richiamato nel application.properties,
//    private String secret;// lo salvo in una variabile così da poterlo usare quando mi serve
//
//    public String generateToken(Utente utente) {
//        return Jwts.builder()
//                .issuedAt(new Date(System.currentTimeMillis()))//data di emissione in millisecondi
//                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))//data di scadenza
//                .subject(String.valueOf(dipendente.getIdDipendente()))//a chi appartiene
//                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))//firmo il token fornendoli il segreto
//                .compact();
//    }
//
//    public void verifyToken(String token) {
//        try {
//            Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).build().parse(token);
//        } catch (Exception exception) {
//            throw new UnautorizedException("Si è verificato un problema. Riprova.");
//        }
//    }
//
//    public UUID extractIdFromToken(String token) {
//        return UUID.fromString(Jwts.parser()
//                .verifyWith(Keys.hmacShaKeyFor(secret.getBytes()))
//                .build()
//                .parseSignedClaims(token)
//                .getPayload()
//                .getSubject());
//    }
//}
