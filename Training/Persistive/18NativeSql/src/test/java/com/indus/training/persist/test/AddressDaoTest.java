package com.indus.training.persist.test;

import com.indus.training.persist.dao.AddressDao;
import com.indus.training.persist.entity.Address;
import com.indus.training.persist.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressDaoTest {

    private AddressDao addressDao;
    private Session session;

    @Before
    public void setUp() {
        addressDao = new AddressDao();
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @After
    public void tearDown() {
        if (session != null) {
            session.close();
        }
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
    public void testGetAddress() {
        Address address = new Address();
        address.setStreet("202 Birch St");
        address.setCity("Birchtown");
        addressDao.saveAddress(address);
        
        Address retrievedAddress = addressDao.getAddress(address.getAddressID());
        assertNotNull(retrievedAddress);
        assertEquals("202 Birch St", retrievedAddress.getStreet());
    }
}
