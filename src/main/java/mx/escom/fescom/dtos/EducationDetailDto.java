package mx.escom.fescom.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EducationDetailDto {

    private Long id;
    private String institutionName;
    private String degree;
    private String level;
    private Boolean currentlyInSchool;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;

}
