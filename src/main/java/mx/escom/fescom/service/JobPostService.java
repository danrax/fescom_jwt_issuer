package mx.escom.fescom.service;

import mx.escom.fescom.dtos.JobPostDto;
import mx.escom.fescom.entities.Company;
import mx.escom.fescom.entities.JobPost;

import java.util.List;

public interface JobPostService {

    JobPost getJobPostByVacancyId(Long vacancyId);

    JobPost findJobPostByIdAndCompanyId(Company company, Long jobPostId1);

    JobPostDto createJobPost(JobPostDto jobPostDto);

    List<JobPostDto> getAllJobPosts(int page, int limit);

    JobPostDto getJobPostById(Long id);
}
