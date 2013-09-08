package by.vsu.emdsproject.repository;

import by.vsu.emdsproject.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
