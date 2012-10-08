/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package by.vsu.emdsproject.dbdao;

import by.vsu.emdsproject.dao.AddressDAO;
import by.vsu.emdsproject.model.Address;
import java.util.List;

/**
 *
 * @author Max
 */
public class DBAddressDAO extends AbstractDBDAO<Address> implements AddressDAO{

    public void create(Address e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Address read(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Address e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Address> getList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
