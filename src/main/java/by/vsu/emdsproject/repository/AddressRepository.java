package by.vsu.emdsproject.repository;

import by.vsu.emdsproject.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Max
 *         Date: 23.03.13
 *         Time: 23:14
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
}
