package mx.escom.fescom.service.impl;

import mx.escom.fescom.entities.JobPost;
import mx.escom.fescom.repositories.JobPostRepository;
import mx.escom.fescom.service.JobPostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

public class JobPostServiceImpl implements JobPostService {


    private final JobPostRepository jobPostRepository;

    public JobPostServiceImpl(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }


    @Override
    public JobPost getJobPostByVacancyId(Long vacancyId) {
        Optional<JobPost> jobPost = jobPostRepository.findById(vacancyId);

        if (jobPost.isPresent())
            return jobPost.get();
        else
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Job post not found for id: " + vacancyId);

    }
}
