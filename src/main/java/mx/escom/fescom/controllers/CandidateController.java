package mx.escom.fescom.controllers;

import mx.escom.fescom.dtos.CandidateDto;
import mx.escom.fescom.dtos.GenericResponse;
import mx.escom.fescom.service.impl.CandidateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/candidate")
public class CandidateController {

    private CandidateServiceImpl candidateService;

    @Autowired
    public CandidateController(CandidateServiceImpl candidateService){
        this.candidateService = candidateService;
    }


    @PostMapping("/register")
    public ResponseEntity<GenericResponse> register(@RequestBody CandidateDto candidate) throws Exception {
        return ResponseEntity.ok(candidateService.createCandidate(candidate)) ;
    }
}
