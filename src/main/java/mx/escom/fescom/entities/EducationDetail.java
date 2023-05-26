package mx.escom.fescom.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity(name = "education_detail")
public class EducationDetail {


    @Id
    @Column(name = "education_detail_id")
    private Long id;

    @Column(name = "institution_name")
    private String institutionName;

    @Column(name = "degree")
    private String degree;

    @Column(name = "level")
    private String level;

    @Column(name = "isCurrently_")
    private Boolean currentlyInSchool;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
