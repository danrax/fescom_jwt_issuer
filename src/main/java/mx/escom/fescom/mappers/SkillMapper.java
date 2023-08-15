package mx.escom.fescom.mappers;

import mx.escom.fescom.dtos.SkillSet;
import mx.escom.fescom.entities.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SkillMapper {

    SkillMapper INSTANCE = Mappers.getMapper( SkillMapper.class);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "candidate", ignore = true)
    Skill toEntity(SkillSet skillSet);

    SkillSet toDto(Skill skill);
}
