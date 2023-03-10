package mx.escom.fescom.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity(name = "skills")
public class Skill {

    @Id
    @Column(name = "skill_id")
    private long id;

    @Column(name = "name")
    private int name;

    @Column(name = "slug")
    private String slug;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
