package mx.escom.fescom.mappers;

import mx.escom.fescom.dtos.ExperienceDetailDto;
import mx.escom.fescom.entities.ExperienceDetail;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface ExperienceDetailMapper {

    ExperienceDetailMapper INSTANCE = Mappers.getMapper( ExperienceDetailMapper.class);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ExperienceDetail toEntity(ExperienceDetailDto experienceDetailDto);
}
