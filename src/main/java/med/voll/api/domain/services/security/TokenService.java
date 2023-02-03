package med.voll.api.domain.services.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import med.voll.api.domain.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${key.security.token.secret: ${JWT_SECRET:10210202}}")
    private String secret;

    public String generateToken(User user) {
        try {
            var algorithm = Algorithm.HMAC256(secret); //password
            return JWT.create() //to generate jwt
                    .withIssuer("API eduardo.greff") //to identify who's the owner of implementation
                    .withSubject(user.getLogin()) //identify which user's the owner of token
                    .withExpiresAt(expirationDate())
                    .sign(algorithm); //just to signed

        } catch (JWTCreationException exception) {
            throw new RuntimeException("error when trying to generate JWT", exception);
        }
    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
