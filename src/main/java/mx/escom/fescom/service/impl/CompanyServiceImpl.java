package mx.escom.fescom.service.impl;

import mx.escom.fescom.dtos.CompanyDto;
import mx.escom.fescom.mappers.CompanyMapper;
import mx.escom.fescom.repositories.CompanyRepository;
import mx.escom.fescom.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {

        return CompanyMapper.INSTANCE.toDto(
                companyRepository.saveAndFlush(CompanyMapper.INSTANCE.toEntity(companyDto)) );
    }
}
