package mx.escom.fescom.service;

import mx.escom.fescom.dtos.CandidateDto;
import mx.escom.fescom.dtos.JobPostDto;
import mx.escom.fescom.entities.Company;
import mx.escom.fescom.entities.JobPost;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobPostService {

    JobPost getJobPostByVacancyId(Long vacancyId);

    JobPost findJobPostByIdAndCompanyId(Company company, Long jobPostId1);

    JobPostDto createJobPost(JobPostDto jobPostDto);

    List<JobPostDto> getAllJobPosts(int page, int limit);

    JobPostDto getJobPostById(Long id);

    JobPostDto updateJobPost(JobPostDto jobPostDto);

    void deleteJobPost(Long id);

    void apply(Long id, CandidateDto candidateDto);

    List<CandidateDto> getCandidatesAppliedToAJobsPost(Long id);
}
