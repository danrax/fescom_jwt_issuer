package mx.escom.fescom.service;

import mx.escom.fescom.dtos.CandidateDto;
import mx.escom.fescom.dtos.GenericResponse;

public interface CandidateService {

    GenericResponse createCandidate(CandidateDto candidate) throws Exception;
}
