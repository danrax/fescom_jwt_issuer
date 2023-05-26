package mx.escom.fescom.mappers;

import mx.escom.fescom.dtos.CandidateDto;
import mx.escom.fescom.entities.Candidate;
import org.mapstruct.factory.Mappers;

public interface CandidateMapper {

    CandidateMapper INSTANCE = Mappers.getMapper(CandidateMapper.class);

    CandidateDto toDto(Candidate candidate);

    Candidate toEntity(CandidateDto candidateDto);
}
