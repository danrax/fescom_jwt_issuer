package mx.escom.fescom.controllers;

import mx.escom.fescom.dtos.SkillSet;
import mx.escom.fescom.service.impl.SkillServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/skill-set")
public class SkillSetcontroller {

    private final SkillServiceImpl skillService;

    public SkillSetcontroller(SkillServiceImpl skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/")
    public ResponseEntity<List<SkillSet>> getAllSkillSets(){
        return ResponseEntity.ok(skillService.getAllSkills());
    }
}
