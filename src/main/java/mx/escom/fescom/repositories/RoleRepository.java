package mx.escom.fescom.repositories;

import mx.escom.fescom.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long>{

    Role findByName(String name);
}
