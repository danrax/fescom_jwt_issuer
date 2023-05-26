package mx.escom.fescom.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "job_post")
@Data
public class JobPost {

    @Id
    @Column(name = "job_post_id")
    private Long id;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "job_title")
    private String jobTiitle;

    @Column(name = "description")
    private String description;

    @Column(name = "requirements")
    private String requirements;

    @Column(name = "experience")
    private String experience;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @Column(name = "job_type")
    private String jobPostType;

    @Column(name = "job_mode")
    private String jobMode;

    @Column(name = "salary_min")
    private float salaryMin;

    @Column(name = "salary_max")
    private float salaryMax;

    @Column(name = "views")
    private float views;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany
    private List<Candidate> candidates;
}
