package mx.escom.fescom.controllers;


import mx.escom.fescom.dtos.CandidateDto;
import mx.escom.fescom.dtos.CompanyDto;
import mx.escom.fescom.dtos.GenericResponse;
import mx.escom.fescom.dtos.JobPostDto;
import mx.escom.fescom.service.impl.JobPostServiceImpl;
import org.apache.coyote.Response;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/job-posts")
public class JobPostController {

    private final JobPostServiceImpl jobPostService;

    public JobPostController(JobPostServiceImpl jobPostService) {
        this.jobPostService = jobPostService;
    }

    @PostMapping("/")
    public ResponseEntity<JobPostDto> createJobPost(@RequestBody JobPostDto jobPostDto) {
        return ResponseEntity.ok(jobPostService.createJobPost(jobPostDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<JobPostDto>> getAllJobPost( @DefaultValue("0") @RequestParam("page") int page,
                                                          @DefaultValue("50") @RequestParam("limit") int limit ){
        return ResponseEntity.ok(jobPostService.getAllJobPosts(page, limit));
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPostDto> getJobPostById( @PathVariable Long id){
        return ResponseEntity.ok(jobPostService.getJobPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPostDto> updateJobPost( @PathVariable Long id, @RequestBody JobPostDto jobPostDto){
        jobPostDto.setId(id);
        return ResponseEntity.ok(jobPostService.updateJobPost(jobPostDto));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteJobPost(@PathVariable Long id){

        jobPostService.deleteJobPost(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/apply")
    public ResponseEntity<JobPostDto> createJobApplication(@PathVariable Long id, @RequestBody CandidateDto candidateDto) {
        jobPostService.apply(id, candidateDto);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/candidates-applied")
    public ResponseEntity<List<CandidateDto>> getCandidatesApplied(@PathVariable Long id){

        return ResponseEntity.ok(jobPostService.getCandidatesAppliedToAJobsPost(id));
    }

}
