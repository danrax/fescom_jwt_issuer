package mx.escom.fescom.service.impl;

import mx.escom.fescom.dtos.JwtResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

//@Service
public class TokenService {

    //private final JwtEncoder encoder;

    private static final Integer EXPIRATION_TIME_IN_SECONDS =3600;

    /*
    * public TokenService(JwtEncoder encoder) {
        this.encoder = encoder;
    }

    public JwtResponse generateToken(Authentication authentication) {
        Instant now = Instant.now();
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(EXPIRATION_TIME_IN_SECONDS, ChronoUnit.SECONDS))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();

        JwtResponse response = new JwtResponse(
                this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue(),
                authentication.getName(),
                EXPIRATION_TIME_IN_SECONDS,
                null
        );

        return response;
    }
    *
    * */

}
