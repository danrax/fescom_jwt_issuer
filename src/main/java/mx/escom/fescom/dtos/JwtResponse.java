package mx.escom.fescom.dtos;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {

    private String type = "Bearer";
    private String username;
    private int expiration;
    private String token;
    private List<String> roles;

    public JwtResponse(String accessToken, String username, int expiration, List<String> roles) {
        this.token = accessToken;
        this.username = username;
        this.expiration = expiration;
        //this.roles = roles;
    }

}