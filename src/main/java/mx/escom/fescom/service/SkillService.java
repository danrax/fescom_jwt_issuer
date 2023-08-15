package mx.escom.fescom.service;

import mx.escom.fescom.dtos.SkillSet;
import mx.escom.fescom.entities.Candidate;

import java.util.List;

public interface SkillService {

    void createSkills(List<SkillSet> skillSetList, Candidate candidate);

    List<SkillSet> getAllSkills();
}
