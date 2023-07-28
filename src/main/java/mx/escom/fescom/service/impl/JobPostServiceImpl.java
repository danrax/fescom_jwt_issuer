package mx.escom.fescom.service.impl;

import mx.escom.fescom.dtos.JobPostDto;
import mx.escom.fescom.entities.Company;
import mx.escom.fescom.entities.JobPost;
import mx.escom.fescom.mappers.JobPostMapper;
import mx.escom.fescom.repositories.JobPostRepository;
import mx.escom.fescom.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public JobPost findJobPostByIdAndCompanyId(Company companyId, Long jobPostId) {
        Optional<JobPost> jobPost = jobPostRepository.findById(jobPostId);

        if (jobPost.isPresent())
            return jobPost.get();
        else
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Job post not found for id: " + jobPostId);
    }

    @Override
    public JobPostDto createJobPost(JobPostDto jobPostDto) {
        return  JobPostMapper.INSTANCE.toDto(
                jobPostRepository.saveAndFlush(
                        JobPostMapper.INSTANCE.toEntity(jobPostDto)
                ));
    }

    @Override
    public List<JobPostDto> getAllJobPosts(int page, int limit) {
        Pageable pageable = PageRequest.of(page,limit);

        Page<JobPost> jobPosts = jobPostRepository.findAll(pageable);

        List<JobPostDto> jobPostDtoList = new ArrayList<>();

        jobPosts.get().forEach(jobPost -> {
            jobPostDtoList.add(JobPostMapper.INSTANCE.toDto(jobPost));
        });

        return jobPostDtoList;
    }

    @Override
    public JobPostDto getJobPostById(Long id) {
        return  JobPostMapper.INSTANCE.toDto(this.getJobPostByVacancyId(id));
    }
}
