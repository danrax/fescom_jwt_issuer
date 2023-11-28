package mx.escom.fescom.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class HealthController {

    private final String projectVersion = "Fescom 1.0.0";
    @GetMapping("/health")
    public String authenticateUser(Authentication authentication) {
        return projectVersion;
    }
}
