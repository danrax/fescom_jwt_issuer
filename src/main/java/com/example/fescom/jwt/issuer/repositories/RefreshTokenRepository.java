package com.example.fescom.jwt.issuer.repositories;


import java.util.Optional;
import java.util.UUID;

import com.example.fescom.jwt.issuer.models.UserModel;
import com.example.fescom.jwt.issuer.models.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;


@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, UUID> {
    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUser(UserModel userModel);
}