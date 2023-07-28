package mx.escom.fescom.dtos;

import lombok.Data;
import mx.escom.fescom.entities.File;

import java.util.List;

@Data
public class JobPostDto {

    String jobTitle;
    String jobType;
    String jobMode;
    String description;
    String requirements;
    String imageUrl;
    String experience;
    float salaryMin;
    float salaryMax;
    List<SkillSet> skillSets;
    File image;

}
