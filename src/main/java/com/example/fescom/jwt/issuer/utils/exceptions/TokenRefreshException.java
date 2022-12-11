package com.example.fescom.jwt.issuer.utils.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;

public class TokenRefreshException extends RuntimeException {
    public TokenRefreshException( String s) {
        super(s);
    }
}
