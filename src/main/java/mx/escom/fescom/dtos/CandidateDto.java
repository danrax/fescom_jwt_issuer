package mx.escom.fescom.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CandidateDto {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private List<ExperienceDetailDto> experienceDetail;
    private List<EducationDetailDto> educationDetails;
    private long[] skillSets;
    private SkillSet[] updateSkillSets;
    private ContactDetailDto contactDetails;
}
