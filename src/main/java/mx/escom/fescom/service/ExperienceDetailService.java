package mx.escom.fescom.service;

import mx.escom.fescom.dtos.ExperienceDetailDto;
import mx.escom.fescom.entities.Candidate;
import mx.escom.fescom.entities.ExperienceDetail;

import java.util.List;

public interface ExperienceDetailService {

    void createExperienceDetails(List<ExperienceDetailDto> experienceDetailDtoList, Candidate candidate);

    void deleteExperienceDetail(Long experienceDetailId);
}
