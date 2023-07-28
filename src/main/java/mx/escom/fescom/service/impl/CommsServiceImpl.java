package mx.escom.fescom.service.impl;

import mx.escom.fescom.dtos.CompanyDto;
import mx.escom.fescom.dtos.GenericResponse;
import mx.escom.fescom.entities.Company;
import mx.escom.fescom.entities.JobPost;
import mx.escom.fescom.mappers.CompanyMapper;
import mx.escom.fescom.service.CommsService;
import org.springframework.stereotype.Service;

@Service
public class CommsServiceImpl implements CommsService {

    @Override
    public GenericResponse sendInvitationEmail(CompanyDto companyDto) {
        return sendInvitationEmail(CompanyMapper.INSTANCE.toEntity(companyDto));
    }


    @Override
    public GenericResponse sendInvitationEmail(Company company) {
        return new GenericResponse(200, "OK");
    }

    @Override
    public GenericResponse sendJobPostEmail(JobPost jobPost) {
        return new GenericResponse(200, "OK");
    }
}
