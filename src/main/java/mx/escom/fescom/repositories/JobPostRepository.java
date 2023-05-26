package mx.escom.fescom.repositories;

import mx.escom.fescom.entities.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRepository extends JpaRepository<JobPost, Long> {

}
