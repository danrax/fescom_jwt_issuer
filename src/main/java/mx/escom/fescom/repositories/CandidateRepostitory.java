package mx.escom.fescom.repositories;

import mx.escom.fescom.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepostitory extends JpaRepository<Candidate, Long> {

}
