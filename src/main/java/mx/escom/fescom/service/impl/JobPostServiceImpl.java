package mx.escom.fescom.service.impl;

import mx.escom.fescom.dtos.CandidateDto;
import mx.escom.fescom.dtos.JobPostDto;
import mx.escom.fescom.entities.Candidate;
import mx.escom.fescom.entities.Company;
import mx.escom.fescom.entities.JobApplication;
import mx.escom.fescom.entities.JobPost;
import mx.escom.fescom.mappers.CandidateMapper;
import mx.escom.fescom.mappers.JobPostMapper;
import mx.escom.fescom.repositories.CandidateRepository;
import mx.escom.fescom.repositories.JobApplicationRepository;
import mx.escom.fescom.repositories.JobPostRepository;
import mx.escom.fescom.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobPostServiceImpl implements JobPostService {


    private final JobPostRepository jobPostRepository;
    private final JobApplicationRepository jobApplicationRepository;
    private final CandidateRepository candidateRepository;
    private final EmailServiceImpl emailService;

    @Autowired
    public JobPostServiceImpl(JobPostRepository jobPostRepository, JobApplicationRepository jobApplicationRepository,
                              CandidateRepository candidateRepository, EmailServiceImpl emailService) {
        this.jobPostRepository = jobPostRepository;
        this.jobApplicationRepository = jobApplicationRepository;
        this.candidateRepository = candidateRepository;
        this.emailService = emailService;
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

    @Override
    public JobPostDto updateJobPost(JobPostDto jobPostDto) {
        return createJobPost(jobPostDto);
    }

    @Override
    public void deleteJobPost(Long id) {
        jobPostRepository.deleteById(id);
    }

    @Override
    public void apply(Long id, CandidateDto candidateDto) {
        Optional<JobPost> optionalJobPost = jobPostRepository.findById(id);
        Optional<Candidate> candidate = candidateRepository.findById(candidateDto.getId());

        if (!optionalJobPost.isPresent()){
           throw  new HttpClientErrorException(HttpStatus.NOT_FOUND,"JobPost not found for id: " + id);
        }

        JobPost jobPost = optionalJobPost.get();
        Optional<JobApplication> optionalJobApplication = jobApplicationRepository.
                findByJobPost_IdAndCandidate_CandidateId(jobPost.getId(), candidate.get().getCandidateId());

        if (optionalJobApplication.isPresent()){
            throw  new HttpClientErrorException(HttpStatus.BAD_REQUEST,"Candidate already applied to job");
        }

        JobApplication jobApplication = new JobApplication();
        jobApplication.setJobPost(jobPost);
        jobApplication.setCandidate(candidate.get());

        jobApplicationRepository.saveAndFlush(jobApplication);

        emailService.sendJobApplicationEmail(jobApplication);
    }

    @Override
    public List<CandidateDto> getCandidatesAppliedToAJobsPost(Long id) {

        List<JobApplication> jobApplications = jobApplicationRepository.findByJobPost_Id(id);

        if (!jobApplications.isEmpty()){
            throw  new HttpClientErrorException(HttpStatus.NOT_FOUND,"No candidates found for jobPost: "+ id);
        }

        List<CandidateDto> candidateDtos = new ArrayList<>();
        jobApplications.forEach(jobApplication ->{
            candidateDtos.add(CandidateMapper.INSTANCE.toDto(jobApplication.getCandidate()));
        } );

        return candidateDtos;
    }
}
