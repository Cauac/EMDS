package by.vsu.emdsproject.dao.impl;

import by.vsu.emdsproject.dao.AddressDAO;
import by.vsu.emdsproject.model.Address;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAOImpl extends AbstractDAOImpl<Address> implements AddressDAO {

    public AddressDAOImpl() {
        super();
        setClazz(Address.class);
    }
}
