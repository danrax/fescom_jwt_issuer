package mx.escom.fescom.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity(name = "contact_detail")
public class ContactDetail {

    @Id
    @Column(name = "contact_detail_id")
    private Long id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "website")
    private String website;

    @Column(name = "address")
    private String address;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    @Column(name = "facebook_url")
    private String facebookUrl;

    @Column(name = "repository_url")
    private String repositoryUrl;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
