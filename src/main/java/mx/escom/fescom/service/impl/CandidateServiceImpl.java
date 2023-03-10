package mx.escom.fescom.service.impl;

import mx.escom.fescom.dtos.CandidateDto;
import mx.escom.fescom.dtos.GenericResponse;
import mx.escom.fescom.entities.Candidate;
import mx.escom.fescom.entities.Role;
import mx.escom.fescom.entities.User;
import mx.escom.fescom.repositories.CandidateRepostitory;
import mx.escom.fescom.repositories.RoleRepository;
import mx.escom.fescom.repositories.UserRepository;
import mx.escom.fescom.service.CandidateService;
import mx.escom.fescom.utilities.enums.RoleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CandidateServiceImpl implements CandidateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CandidateServiceImpl.class);
    private final UserRepository userRepository;
    private final CandidateRepostitory candidateRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public CandidateServiceImpl(UserRepository userRepository, CandidateRepostitory candidateRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.candidateRepository = candidateRepository;
        this.roleRepository = roleRepository;
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

        candidate = candidateRepository.save(candidate);



        return response;
    }
}
