package mx.escom.fescom.service.impl;

import mx.escom.fescom.dtos.SkillSet;
import mx.escom.fescom.entities.Candidate;
import mx.escom.fescom.entities.Skill;
import mx.escom.fescom.mappers.SkillMapper;
import mx.escom.fescom.repositories.SkillRepository;
import mx.escom.fescom.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillMapper skillMapper = SkillMapper.INSTANCE;

    private final SkillRepository skillRepository;

    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public void createSkills(List<SkillSet> skillSetList, Candidate candidate) {

        if(skillSetList != null){
            List<Skill> skillList = new ArrayList<>();

            skillSetList.forEach(skillSet -> {
                Skill skill = skillMapper.toEntity(skillSet);
                skill.setCandidate(candidate);
                skillList.add(skill);
            });

            skillRepository.saveAllAndFlush(skillList);
        }

    }
}
