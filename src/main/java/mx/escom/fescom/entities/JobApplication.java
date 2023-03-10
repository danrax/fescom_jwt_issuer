package mx.escom.fescom.entities;

import javax.persistence.*;

@Entity( name = "job_application")
public class JobApplication {

    @Id
    @Column(name = "job_application_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "job_post")
    private JobPost jobPost;
}
