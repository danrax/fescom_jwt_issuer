package mx.escom.fescom.service;

import mx.escom.fescom.dtos.EducationDetailDto;
import mx.escom.fescom.entities.Candidate;

import java.util.List;

public interface EducationDetailService {

    void createEducationDetails(List<EducationDetailDto> educationDetailDtoList, Candidate candidate);

    void deleteEducationDetails(Long educationDetailId);
}
