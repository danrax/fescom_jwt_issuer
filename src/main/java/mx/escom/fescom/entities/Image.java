package mx.escom.fescom.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "uploaded_image")
@Data
public class Image {

    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long imageId;

    @Column(name = "url")
    private String imageUrl;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
}
