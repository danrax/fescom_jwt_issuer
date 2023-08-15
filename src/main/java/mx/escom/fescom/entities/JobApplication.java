package mx.escom.fescom.entities;

import lombok.Data;

import javax.persistence.*;

@Entity( name = "job_application")
@Data
public class JobApplication {

    @Id
    @Column(name = "job_application_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "job_post")
    private JobPost jobPost;
}
