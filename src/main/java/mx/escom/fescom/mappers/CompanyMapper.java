package mx.escom.fescom.mappers;

import mx.escom.fescom.dtos.CompanyDto;
import mx.escom.fescom.entities.Company;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CompanyDto toDto(Company company);

    Company toEntity(CompanyDto company);
}
