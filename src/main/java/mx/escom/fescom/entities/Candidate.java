package mx.escom.fescom.entities;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "candidate")
@Data
@Builder
public class Candidate {

    @Id
    @Column(name = "candidate_id")
    private long candidateId;

    @Column(name = "current_salary")
    private float currentSalary;

    @Column(name = "resume")
    private String resume;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    //@OneToMany(mappedBy = "candidate")
    @ManyToMany
    private List<JobApplication> jobApplications;

}
