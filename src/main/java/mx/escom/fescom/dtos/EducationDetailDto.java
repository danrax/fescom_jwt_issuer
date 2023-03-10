package mx.escom.fescom.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class EducationDetailDto {

    private UUID id;
    private String institutionName;
    private String degree;
    private String level;
    private String currentlyInSchool;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;

}
