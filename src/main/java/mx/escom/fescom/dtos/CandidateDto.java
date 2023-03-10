package mx.escom.fescom.dtos;

import lombok.Data;

@Data
public class CandidateDto {

    private String name;
    private String lastName;
    private String email;
    private ExperienceDetailDto experienceDetail;
    private EducationDetailDto educationDetails;
    private long[] skillSets;
    private SkillSet[] updateSkillSets;
    private ContactDetailsDto contactDetails;
}
