/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.model.Address;
import java.util.List;

/**
 *
 * @author Max
 */
public interface AddressDAO extends AbstractDAO<Address> {

    public void create(Address e);

    public Address read(Long id);

    public void update(Address e);

    public void delete(Address e);

    List<Address> getList();
}
