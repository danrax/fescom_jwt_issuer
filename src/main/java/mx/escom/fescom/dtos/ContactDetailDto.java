package mx.escom.fescom.dtos;

import lombok.Data;

@Data
public class ContactDetailDto {

    private Long id;
    private String phone;
    private String address;
    private String website;
    private String linkedinUrl;
    private String facebookUrl;
    private String repositoryUrl;
}
