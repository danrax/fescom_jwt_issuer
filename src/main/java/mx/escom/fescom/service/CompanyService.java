package mx.escom.fescom.service;

import com.example.fescom.jwt.issuer.dtos.UserDto;
import mx.escom.fescom.dtos.CompanyDto;
import mx.escom.fescom.dtos.GenericResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CompanyService {

    CompanyDto createCompany(CompanyDto companyDto);

    GenericResponse inviteCompany(CompanyDto companyDto, MultipartFile imageFile);

    CompanyDto register(UserDto userDto);

    GenericResponse resendInvitation(Long companyId);

    List<CompanyDto> getAllCompanies(int offset, int limit);

    CompanyDto getCompanyById(Long companyId);

    GenericResponse deleteCompany(Long companyId);
}
