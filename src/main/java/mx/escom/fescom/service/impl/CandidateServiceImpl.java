package mx.escom.fescom.service.impl;

import mx.escom.fescom.dtos.CandidateDto;
import mx.escom.fescom.dtos.ContactDetailDto;
import mx.escom.fescom.dtos.GenericResponse;
import mx.escom.fescom.entities.*;
import mx.escom.fescom.mappers.CandidateMapper;
import mx.escom.fescom.mappers.ContactDetailMapper;
import mx.escom.fescom.repositories.*;
import mx.escom.fescom.service.CandidateService;
import mx.escom.fescom.utilities.enums.RoleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidateServiceImpl implements CandidateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CandidateServiceImpl.class);

    //Services section
    private final ExperienceDetailServiceImpl experienceDetailService;
    private final SkillServiceImpl skillService;
    private final EducationDetailServiceImpl educationDetailService;
    private final JobPostServiceImpl jobPostService;

    //Repositories section
    private final UserRepository userRepository;
    private final CandidateRepository candidateRepository;
    private final RoleRepository roleRepository;
    private final ContactDetailRepository contactDetailRepository;


    @Autowired
    public CandidateServiceImpl(ExperienceDetailServiceImpl experienceDetailService, SkillServiceImpl skillService,
                                EducationDetailServiceImpl educationDetailService, JobPostServiceImpl jobPostService,
                                UserRepository userRepository, CandidateRepository candidateRepository,
                                RoleRepository roleRepository, SkillRepository skillRepository,
                                ExperienceDetailRepository experienceDetailRepository,
                                ContactDetailRepository contactDetailRepository) {

        this.experienceDetailService = experienceDetailService;
        this.skillService = skillService;
        this.educationDetailService = educationDetailService;
        this.jobPostService = jobPostService;
        this.userRepository = userRepository;
        this.candidateRepository = candidateRepository;
        this.roleRepository = roleRepository;
        this.contactDetailRepository = contactDetailRepository;
    }

    public GenericResponse createCandidate(CandidateDto candidateDto) throws RuntimeException {
        GenericResponse response = new GenericResponse();

        User user = userRepository.findByEmail(candidateDto.getEmail());

        if (user != null){
            throw new RuntimeException("User already exists");
        }

        LOGGER.debug("Searching role by Name : {}", RoleType.CANDIDATE.name());
        Role role = roleRepository.findByName(RoleType.CANDIDATE.name());

        user = User.builder()
                .name(candidateDto.getName())
                .lastName(candidateDto.getLastName())
                .email(candidateDto.getEmail())
                .password("")
                .role(role)
                .status("active")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Candidate candidate = Candidate.builder()
                .user(user)
                .build();

        candidateRepository.save(candidate);

        //Create skills, experience and education associated to the candidate

        skillService.createSkills( Arrays.asList(candidateDto.getUpdateSkillSets()), candidate);
        experienceDetailService.createExperienceDetails(candidateDto.getExperienceDetail(), candidate);
        educationDetailService.createEducationDetails(candidateDto.getEducationDetails(), candidate);

        response.setStatus(HttpStatus.CREATED.value());
        response.setMessage(HttpStatus.CREATED.name());
        return response;
    }

    @Override
    public ContactDetailDto getContactDetails(Long userId) {

        Optional<User> user = userRepository.findById(userId);

        if(user.isPresent()){
           ContactDetail contactDetail = contactDetailRepository.findByUser(user.get());
           return ContactDetailMapper.INSTANCE.toDto(contactDetail);
        }
        else
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Contact detail not found for user " + userId);
    }

    @Override
    public ContactDetailDto getCandidateContactDetailsByVacancy(Long vacancyId, Long candidateId) {

        JobPost jobPost =jobPostService.getJobPostByVacancyId(vacancyId);

        if (ObjectUtils.isEmpty(jobPost))
            return CandidateMapper.INSTANCE.toDto(
                    jobPost.getCandidates().stream().filter( candidate -> candidate.getCandidateId()== candidateId)
                            .collect(Collectors.toList()).get(0)
            ).getContactDetails();
        else
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,
                    "Candidate contact detail not found for id: " + candidateId);
    }

    @Override
    public CandidateDto getCandidateByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            Optional<Candidate> candidate = candidateRepository.findByUser(user.get());

            if (candidate.isPresent())
                return CandidateMapper.INSTANCE.toDto(candidate.get());
        }
        else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "User not found for id " + userId);
        }
        return  null;
    }

    @Override
    public CandidateDto getCandidateByVacancy(Long vacancyId, Long candidateId) {

        JobPost jobPost =jobPostService.getJobPostByVacancyId(vacancyId);

        if (ObjectUtils.isEmpty(jobPost))
            return CandidateMapper.INSTANCE.toDto(
                    jobPost.getCandidates().stream().filter( candidate -> candidate.getCandidateId()== candidateId)
                            .collect(Collectors.toList()).get(0)
            );
        else
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,
                    "Candidate not found for id: " + candidateId);
    }

    @Override
    public CandidateDto updateCandidate(CandidateDto candidateDto) {

        Candidate candidate = candidateRepository.save(CandidateMapper.INSTANCE.toEntity(candidateDto));
        return CandidateMapper.INSTANCE.toDto(candidate);
    }

    @Override
    public void deleteCandidate(Long candidateId) {

        candidateRepository.delete(candidateRepository.getReferenceById(candidateId));
    }
}
