package mx.escom.fescom.repositories;

import mx.escom.fescom.entities.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {


    Optional<JobApplication> findByJobPost_IdAndCandidate_Id(Long jobPostId, Long candidateId);
    List<JobApplication> findByJobPost_Id(Long jobPostId);
}
