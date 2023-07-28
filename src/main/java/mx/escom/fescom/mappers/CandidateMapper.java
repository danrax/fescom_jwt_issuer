package mx.escom.fescom.mappers;

import mx.escom.fescom.dtos.CandidateDto;
import mx.escom.fescom.entities.Candidate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CandidateMapper {

    CandidateMapper INSTANCE = Mappers.getMapper(CandidateMapper.class);

    @Mapping(target = "candidateId", source = "id")
    @Mapping(target = "currentSalary", ignore = true)
    @Mapping(target = "resume", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "jobApplications", ignore = true)
    @Mapping(target = "user.name", source = "name")
    @Mapping(target = "user.lastName", source = "lastName")
    @Mapping(target = "user.email", source = "email")
    Candidate toEntity(CandidateDto candidateDto);

    @Mapping(target = "id", source = "candidateId")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "lastName", source = "user.lastName")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "experienceDetail", ignore = true)
    @Mapping(target = "educationDetails", ignore = true)
    @Mapping(target = "skillSets", ignore = true)
    @Mapping(target = "updateSkillSets", ignore = true)
    @Mapping(target = "contactDetails", ignore = true)
    CandidateDto toDto(Candidate candidate);
}
