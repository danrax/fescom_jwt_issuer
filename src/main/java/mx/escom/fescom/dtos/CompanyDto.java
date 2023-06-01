package mx.escom.fescom.dtos;

import lombok.Data;

@Data
public class CompanyDto {

    private Long id;
    private String email;
    private String description;
    private String name;
    private String imageURL;
    private String validationToken;

}
