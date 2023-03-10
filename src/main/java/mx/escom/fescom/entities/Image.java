package mx.escom.fescom.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "uploaded_image")
@Data
public class Image {

    @Id
    @Column(name = "image_id")
    private long imageId;

    @Column(name = "url")
    private String imageUrl;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
