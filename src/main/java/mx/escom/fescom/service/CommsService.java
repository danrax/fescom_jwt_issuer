package mx.escom.fescom.service;


import mx.escom.fescom.dtos.CompanyDto;
import mx.escom.fescom.dtos.GenericResponse;
import mx.escom.fescom.entities.Company;
import mx.escom.fescom.entities.JobPost;

public interface CommsService {

    GenericResponse sendInvitationEmail(CompanyDto companyDto);

    GenericResponse sendInvitationEmail(Company company);

    GenericResponse sendJobPostEmail(JobPost jobPost);
}
