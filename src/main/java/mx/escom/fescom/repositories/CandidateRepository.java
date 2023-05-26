package mx.escom.fescom.repositories;

import mx.escom.fescom.entities.Candidate;
import mx.escom.fescom.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Optional<Candidate> findByUser(User user);

}
