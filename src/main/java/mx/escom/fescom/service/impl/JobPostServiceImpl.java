package mx.escom.fescom.service.impl;

import mx.escom.fescom.entities.JobPost;
import mx.escom.fescom.repositories.JobPostRepository;
import mx.escom.fescom.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class JobPostServiceImpl implements JobPostService {


    private final JobPostRepository jobPostRepository;

    @Autowired
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
