package mx.escom.fescom.mappers;

import javax.annotation.processing.Generated;
import mx.escom.fescom.dtos.SkillSet;
import mx.escom.fescom.entities.Skill;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-09T22:07:13-0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
public class SkillMapperImpl implements SkillMapper {

    @Override
    public Skill SkillSetToSkill(SkillSet skillSet) {
        if ( skillSet == null ) {
            return null;
        }

        Skill skill = new Skill();

        skill.setId( skillSet.getId() );
        if ( skillSet.getName() != null ) {
            skill.setName( Integer.parseInt( skillSet.getName() ) );
        }
        skill.setSlug( skillSet.getSlug() );

        return skill;
    }
}
