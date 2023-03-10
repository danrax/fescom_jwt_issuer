package mx.escom.fescom.controllers;

import mx.escom.fescom.dtos.JwtResponse;
import mx.escom.fescom.service.impl.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public ResponseEntity<JwtResponse> authenticateUser(Authentication authentication) {
        LOG.debug("Token requested for user: '{}'", authentication.getName());
        JwtResponse token = tokenService.generateToken(authentication);
        LOG.debug("Token granted: {}", token);
        return ResponseEntity.ok(token);
    }

}
