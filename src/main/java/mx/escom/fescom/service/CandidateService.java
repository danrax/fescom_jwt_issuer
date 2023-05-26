package mx.escom.fescom.service;

import mx.escom.fescom.dtos.CandidateDto;
import mx.escom.fescom.dtos.ContactDetailDto;
import mx.escom.fescom.dtos.GenericResponse;

public interface CandidateService {

    GenericResponse createCandidate(CandidateDto candidate) throws Exception;

    ContactDetailDto getContactDetails(Long userId);

    ContactDetailDto getCandidateContactDetailsByVacancy(Long vacancyId, Long candidateId);

    CandidateDto getCandidateByUserId(Long userId);

    CandidateDto getCandidateByVacancy(Long vacancyId, Long candidateId);

    CandidateDto updateCandidate(CandidateDto candidate);

    void deleteCandidate(Long candidateId);
}
