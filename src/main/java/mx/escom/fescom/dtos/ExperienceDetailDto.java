package mx.escom.fescom.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExperienceDetailDto {

    private Long id;
    private Boolean isCurrentJob;
    private LocalDate startDate;
    private LocalDate endDate;
    private String jobTitle;
    private String jobDescription;
    private String companyName;

}
