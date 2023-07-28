package mx.escom.fescom.mappers;

import mx.escom.fescom.dtos.EducationDetailDto;
import mx.escom.fescom.entities.EducationDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EducationDetailMapper {

    EducationDetailMapper INSTANCE = Mappers.getMapper( EducationDetailMapper.class);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "candidate", ignore = true)
    EducationDetail toEntity(EducationDetailDto educationDetailDto);
}
