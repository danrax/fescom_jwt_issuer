package mx.escom.fescom.repositories;

import mx.escom.fescom.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByActiveEmail(String email);
}
