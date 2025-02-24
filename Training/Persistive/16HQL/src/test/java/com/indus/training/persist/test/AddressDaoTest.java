package com.indus.training.persist.test;

import com.indus.training.persist.dao.AddressDao;
import com.indus.training.persist.entity.Address;
import com.indus.training.persist.util.HibernateUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AddressDaoTest {

    private AddressDao addressDao;

    @Before
    public void setUp() {
        addressDao = new AddressDao();
    }

    @Test
    public void testSaveAddress() {
        Address address = new Address();
        address.setStreet("456 Oak St");
        address.setCity("Oaktown");
        address.setCountry("Country");

        addressDao.saveAddress(address);

        // Verify address was saved
        Address retrievedAddress = addressDao.getAddress(address.getAddressID());
        assertNotNull(retrievedAddress);
        assertEquals("456 Oak St", retrievedAddress.getStreet());
    }

    @Test
    public void testUpdateAddress() {
        Address address = new Address();
        address.setStreet("789 Pine St");
        address.setCity("Pineland");
        addressDao.saveAddress(address);

        address.setStreet("789 Pine Avenue");
        addressDao.updateAddress(address);

        Address updatedAddress = addressDao.getAddress(address.getAddressID());
        assertEquals("789 Pine Avenue", updatedAddress.getStreet());
    }

    @Test
    public void testDeleteAddress() {
        Address address = new Address();
        address.setStreet("101 Maple St");
        address.setCity("Mapleton");
        addressDao.saveAddress(address);

        addressDao.deleteAddress(address.getAddressID());

        Address deletedAddress = addressDao.getAddress(address.getAddressID());
        assertNull(deletedAddress);
    }

    @Test
    public void testGetAllAddresses() {
        List<Address> addresses = addressDao.getAllAddresses();
        assertNotNull(addresses);
        assertFalse(addresses.isEmpty());
    }
}
