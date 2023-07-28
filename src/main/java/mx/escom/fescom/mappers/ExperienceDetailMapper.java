package mx.escom.fescom.mappers;

import mx.escom.fescom.dtos.ExperienceDetailDto;
import mx.escom.fescom.entities.ExperienceDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExperienceDetailMapper {

    ExperienceDetailMapper INSTANCE = Mappers.getMapper( ExperienceDetailMapper.class);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "candidate", ignore = true)
    ExperienceDetail toEntity(ExperienceDetailDto experienceDetailDto);
}
