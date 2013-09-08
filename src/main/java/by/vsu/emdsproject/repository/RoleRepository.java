package by.vsu.emdsproject.repository;

import by.vsu.emdsproject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByAuthority(String authority);
}
