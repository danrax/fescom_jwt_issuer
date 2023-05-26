package mx.escom.fescom.repositories;

import mx.escom.fescom.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
