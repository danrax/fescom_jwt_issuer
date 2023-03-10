package mx.escom.fescom.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ExperienceDetailDto {
    private UUID id;
    private Boolean isCurrentJob;
    private LocalDate startDate;
    private LocalDate endDate;
    private String jobTitle;
    private String jobDescription;
    private String companyName;

}
