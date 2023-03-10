package mx.escom.fescom.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SkillSet {
    private long id;
    private String name;
    private String slug;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
