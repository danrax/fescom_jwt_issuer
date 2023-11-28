package mx.escom.fescom.service.impl;

import com.example.fescom.jwt.issuer.dtos.UserDto;
import mx.escom.fescom.dtos.CompanyDto;
import mx.escom.fescom.dtos.GenericResponse;
import mx.escom.fescom.entities.Company;
import mx.escom.fescom.entities.Image;
import mx.escom.fescom.entities.JobPost;
import mx.escom.fescom.entities.User;
import mx.escom.fescom.mappers.CompanyMapper;
import mx.escom.fescom.repositories.CompanyRepository;
import mx.escom.fescom.repositories.RoleRepository;
import mx.escom.fescom.repositories.UserRepository;
import mx.escom.fescom.service.CompanyService;
import mx.escom.fescom.utilities.enums.RoleType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final StorageServiceImpl storageService;
    private final ImageServiceImpl imageService;
    private final CommsServiceImpl commsService;
    private final JobPostServiceImpl jobPostService;

    private final CompanyRepository companyRepository;
    private final RoleRepository roleRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository, StorageServiceImpl storageService,
                              ImageServiceImpl imageService, CommsServiceImpl commsService,
                              JobPostServiceImpl jobPostService, UserRepository userRepository, RoleRepository roleRepository) {
        this.companyRepository = companyRepository;
        this.storageService = storageService;
        this.imageService = imageService;
        this.commsService = commsService;
        this.jobPostService = jobPostService;
        this.roleRepository = roleRepository;
    }

    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {

        return CompanyMapper.INSTANCE.toDto(
                companyRepository.saveAndFlush(CompanyMapper.INSTANCE.toEntity(companyDto)) );
    }

    @Override
    public GenericResponse inviteCompany(CompanyDto companyDto, MultipartFile imageFile) {

        Optional<Company> companyOptional = companyRepository.findByActiveEmail(companyDto.getEmail());
        if ( !companyOptional.isPresent() ){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Company already exist for email: " + companyDto.getEmail());
        }

        Image image = storageService.uploadFileToStorage(imageFile, buildName(imageFile.getName(),companyDto.getEmail()));
        imageService.saveImage(image);

        Company company = CompanyMapper.INSTANCE.toEntity(companyDto);
        company.setImage(image);

        companyRepository.saveAndFlush(company);

        return commsService.sendInvitationEmail(companyDto);
    }

    public CompanyDto register(UserDto userDto) {

        if(isValidToken(userDto.getValidationToken())){

            Optional<Company> companyOptional = companyRepository.findByActiveEmail(userDto.getEmail());
            if (companyOptional.isPresent()){

                User user = User.builder()
                        .email(userDto.getEmail())
                        .name(userDto.getName())
                        .lastName(userDto.getLastName())
                        .role(roleRepository.findByName(RoleType.COMPANY.name()))
                        .build();
                Company company = companyOptional.get();
                company.setUser(user);

                companyRepository.saveAndFlush(company);
                return CompanyMapper.INSTANCE.toDto(company);
            }
            else
                throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Company not found for email: " + userDto.getEmail());

        }
        return null;
    }

    @Override
    public GenericResponse resendInvitation(Long companyId) {
        Company company = companyRepository.getReferenceById(companyId);

        if (ObjectUtils.isEmpty(company))
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,
                    "Company not found for id: " + companyId);

        return commsService.sendInvitationEmail(company);
    }

    @Override
    public List<CompanyDto> getAllCompanies(int offset, int limit) {
        Pageable pageable = PageRequest.of(offset,limit);

        Page<Company> companies = companyRepository.findAll(pageable);
        List<CompanyDto> companyList= new ArrayList<>();
        companies.getContent().forEach(company -> {
            companyList.add(CompanyMapper.INSTANCE.toDto(company));
        });
        return companyList;
    }

    @Override
    public CompanyDto getCompanyById(Long companyId) {
        Optional<Company> companyOptional = companyRepository.findById(companyId);

        if ( !companyOptional.isPresent() ){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Company not found for id: " + companyId);
        }

        return CompanyMapper.INSTANCE.toDto(companyOptional.get());
    }

    @Override
    public GenericResponse deleteCompany(Long companyId) {

        companyRepository.deleteById(companyId);

        return new GenericResponse(HttpStatus.NO_CONTENT.value(), "Deleted Successfully");
    }

    @Override
    public void sendApplyCandidates(Long companyId, Long jobPostId) {
        CompanyDto companyDto = this.getCompanyById(companyId);

        JobPost jobpost = jobPostService.findJobPostByIdAndCompanyId(
                CompanyMapper.INSTANCE.toEntity(companyDto), jobPostId);

        commsService.sendJobPostEmail(jobpost);
    }

    private boolean isValidToken(String validationToken) {
        return true;
    }

    private String buildName(String name, String email) {

        return  email+"/"+ LocalDate.now().toString() +"-"+ name;
    }
}
