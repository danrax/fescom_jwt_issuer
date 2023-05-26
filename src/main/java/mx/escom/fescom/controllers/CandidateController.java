package mx.escom.fescom.controllers;

import mx.escom.fescom.dtos.CandidateDto;
import mx.escom.fescom.dtos.ContactDetailDto;
import mx.escom.fescom.dtos.GenericResponse;
import mx.escom.fescom.service.impl.CandidateServiceImpl;
import mx.escom.fescom.service.impl.EducationDetailServiceImpl;
import mx.escom.fescom.service.impl.ExperienceDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/candidate")
public class CandidateController {

    private final CandidateServiceImpl candidateService;
    private final EducationDetailServiceImpl educationDetailService;
    private final ExperienceDetailServiceImpl experienceDetailService;

    @Autowired
    public CandidateController(CandidateServiceImpl candidateService,
                               EducationDetailServiceImpl educationDetailService,
                               ExperienceDetailServiceImpl experienceDetailService){
        this.candidateService = candidateService;
        this.educationDetailService = educationDetailService;
        this.experienceDetailService = experienceDetailService;
    }


    @PostMapping("/register")
    public ResponseEntity<GenericResponse> register(@RequestBody CandidateDto candidate) {
        return ResponseEntity.ok(candidateService.createCandidate(candidate)) ;
    }

    @GetMapping("/{userId}/contact")
    public ResponseEntity<ContactDetailDto> getUserContactDetails(@PathVariable Long userId){
        return ResponseEntity.ok(candidateService.getContactDetails(userId));
    }


    @GetMapping("/contact/{vacancyId}/{candidateId}")
    public ResponseEntity<ContactDetailDto> getCandidateContactDetails(@PathVariable Long vacancyId,
                                                                       @PathVariable Long candidateId){

        return ResponseEntity.ok(candidateService.getCandidateContactDetailsByVacancy(vacancyId, candidateId));
    }

    @GetMapping("/{vacancyId}/{candidateId}")
    public ResponseEntity<CandidateDto> getCandidateById(@PathVariable Long vacancyId,
                                                                       @PathVariable Long candidateId){

        return ResponseEntity.ok(candidateService.getCandidateByVacancy(vacancyId, candidateId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CandidateDto> getCandidate(@PathVariable Long userId){

        return ResponseEntity.ok(candidateService.getCandidateByUserId(userId));
    }

    @PutMapping("/update")
    public ResponseEntity<CandidateDto> updateCandidate(@RequestBody CandidateDto candidate){

        return ResponseEntity.ok(candidateService.updateCandidate(candidate));
    }

    @DeleteMapping("/education-detail/{educationDetailId}")
    public ResponseEntity<Void> deleteEducationDetails(@PathVariable Long educationDetailId){
        educationDetailService.deleteEducationDetails(educationDetailId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/experience-detail/{experienceDetailId}")
    public ResponseEntity<Void> deleteExperienceDetail(@PathVariable Long experienceDetailId){
        experienceDetailService.deleteExperienceDetail( experienceDetailId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/candidateId")
    public ResponseEntity<Void> deleteCandidate(@PathVariable Long candidateId){
        candidateService.deleteCandidate(candidateId);
        return ResponseEntity.noContent().build();
    }

}
