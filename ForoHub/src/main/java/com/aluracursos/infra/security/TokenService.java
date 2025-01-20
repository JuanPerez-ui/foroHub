package com.aluracursos.infra.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.aluracursos.usuario.Usuario;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${foroHub.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("foro hub")
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }

    public String getSubject(String token){
        DecodedJWT verifier = null;
        if (token == null){
            throw new RuntimeException("el token no llega");
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    // specify any specific claim validations
                    .withIssuer("foro hub")
                    // reusable verifier instance
                    .build()
                    .verify(token);
            verifier.getSubject();
        } catch (JWTVerificationException exception){
            System.out.println(exception.toString());
        }
        if (verifier.getSubject() == null){
            throw new RuntimeException("Verifier invalido");
        }
        return verifier.getSubject();
    }

    private Instant generarFechaExpiracion(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
