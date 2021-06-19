package home.javaweb.config.sercurity;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import home.javaweb.entity.Privilege;
import home.javaweb.entity.User;
import static home.javaweb.config.sercurity.SecurityConstants.TOKEN_PREFIX;
@Component
public class JwtOutils {
    @Value("${springbootwebfluxjjwt.jjwt.secret}")
    private String secret;
    @Value("${springbootwebfluxjjwt.jjwt.expiration}")
    private long expiration;


    public DecodedJWT verify(String token) throws JWTVerificationException {
        return JWT.require(
//                Algorithm.RSA512(new )
                Algorithm.HMAC512(secret.getBytes())
        )
                .build()
                .verify(token.replace(TOKEN_PREFIX, ""));
    }

    public String create(User user) throws JWTVerificationException {
        Collection<Privilege> authorities = user.getAuthorities();
        String[] privileges = authorities.stream()
                .map(privilege -> privilege.getAuthority())
                .distinct().toArray(String[]::new);
        return JWT.create()
                .withSubject(user.getUsername())
                .withArrayClaim("privileges", privileges)
                .withExpiresAt(new Date(System.currentTimeMillis() + expiration))
                .sign(HMAC512(secret.getBytes()));
//                .sign(HMAC512(secret.getBytes()));
    }
}
