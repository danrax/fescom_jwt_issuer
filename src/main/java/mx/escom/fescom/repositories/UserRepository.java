package mx.escom.fescom.repositories;

import mx.escom.fescom.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
