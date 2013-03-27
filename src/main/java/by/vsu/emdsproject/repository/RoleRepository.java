package by.vsu.emdsproject.repository;

import by.vsu.emdsproject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Max
 *         Date: 23.03.13
 *         Time: 23:16
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByAuthority(Role role);
}
