package mx.escom.fescom.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "company")
public class Company {

    @Id
    @Column(name = "company_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "invitation_email")
    private String invitationEmail;

    @Column(name = "active_email")
    private String activeEmail;

    @Column(name = "description")
    private String description;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "staff")
    private String staff;

    @Column(name = "is_active")
    private String isActive;

    @Column(name = "state")
    private String state;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "company")
    private List<JobPost> jobPosts;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
