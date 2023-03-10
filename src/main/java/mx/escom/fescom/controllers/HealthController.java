package mx.escom.fescom.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HealthController {


    @GetMapping("/health")
    public String authenticateUser(Authentication authentication) {
        return "Hello World ";
    }
}
