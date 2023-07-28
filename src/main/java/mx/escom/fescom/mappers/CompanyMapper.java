package mx.escom.fescom.mappers;

import mx.escom.fescom.dtos.CompanyDto;
import mx.escom.fescom.entities.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    @Mapping(target = "email", source="activeEmail")
    @Mapping(target = "imageUrl", source="image.imageUrl")
    @Mapping(target = "validationToken", ignore = true)
    CompanyDto toDto(Company company);

    @Mapping(source = "email", target="activeEmail" )
    @Mapping(source = "imageUrl", target="image.imageUrl" )
    @Mapping(target = "invitationEmail", ignore = true)
    @Mapping(target = "staff", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "state", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "jobPosts", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Company toEntity(CompanyDto company);
}
