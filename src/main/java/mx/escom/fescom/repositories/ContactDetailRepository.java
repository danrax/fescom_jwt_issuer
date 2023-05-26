package mx.escom.fescom.repositories;

import mx.escom.fescom.entities.ContactDetail;
import mx.escom.fescom.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDetailRepository extends JpaRepository<ContactDetail, Long> {

    ContactDetail findByUser(User user);
}
