package com.example.fescom.jwt.issuer.controllers;

import com.example.fescom.jwt.issuer.dtos.JwtResponse;
import com.example.fescom.jwt.issuer.dtos.TokenRefreshRequest;
import com.example.fescom.jwt.issuer.dtos.TokenRefreshResponse;
import com.example.fescom.jwt.issuer.models.UserModel;
import com.example.fescom.jwt.issuer.services.RefreshTokenService;
import com.example.fescom.jwt.issuer.utils.JwtUtils;
import com.example.fescom.jwt.issuer.models.RefreshToken;
import com.example.fescom.jwt.issuer.utils.exceptions.TokenRefreshException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    RefreshTokenService refreshTokenService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserModel userModel) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userModel.getUsername(), userModel.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserModel userModelDetails = (UserModel) authentication.getPrincipal();

        String jwt = jwtUtils.generateJwtToken(userModelDetails);

        List<String> roles = userModelDetails.getAuthorities().stream().map(item -> item.getAuthority())
                .collect(Collectors.toList());

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userModelDetails.getId());

        return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userModelDetails.getId(),
                userModelDetails.getUsername(), userModelDetails.getEmail(), roles));
    }

    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshToken(@Valid @RequestBody TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();

        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUserModel)
                .map(user -> {
                    String token = jwtUtils.generateTokenFromUsername(user.getUsername());
                    return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
                })
                .orElseThrow(() -> new TokenRefreshException("Refresh token is not in database!"));
    }

}
