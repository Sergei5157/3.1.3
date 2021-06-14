package web.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.spring_boot.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
