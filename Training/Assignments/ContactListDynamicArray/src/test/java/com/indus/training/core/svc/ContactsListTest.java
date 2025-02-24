package com.indus.training.core.svc;
import junit.framework.TestCase;

import java.io.IOException;

import com.indus.training.core.impl.ContactsList;

/**
 * Unit test cases for the ContactsList class.
 */
public class ContactsListTest extends TestCase {

    private ContactsList contactsList;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        contactsList = new ContactsList(3); // Initial capacity set to 3
    }

    /**
     * Test adding valid contacts.
     */
    public void testAddValidContacts() throws Exception {
        contactsList.addContacts("Alice", 12345);
        contactsList.addContacts("Bob", 54321);
        assertEquals("[Alice: 12345, Bob: 54321]", contactsList.getContacts());
        assertEquals(3, contactsList.getContactsArraySize()); // Ensure size remains as initial
    }   
    
    /**
     * Test adding Invalid contacts.
     */
    public void testAddInValidContacts() throws Exception {
        contactsList.addContacts("Alice", 12345);
        contactsList.addContacts("Bob", 54321);
        contactsList.addContacts("nancy", 98761);
        assertEquals("[Alice: 12345, Bob: 54321, nancy: 98761]", contactsList.getContacts());
        assertEquals(3, contactsList.getContactsArraySize()); // Ensure size remains as initial
    }

    /**
     * Test adding contact with invalid number length.
     */
    public void testAddContactWithInvalidNumberLength() {
        try {
            contactsList.addContacts("Charlie", 123); // Invalid contact number length
            fail("Expected IOException for contact number length not equal to 5");
        } catch (IOException e) {
        	System.out.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Test adding more contacts than initial capacity and automatic resizing.
     */
    public void testAddMoreContactsThanInitialCapacity() throws Exception {
        contactsList.addContacts("Alice", 12345);
        contactsList.addContacts("Bob", 54321);
        contactsList.addContacts("Charlie", 23451);
        contactsList.addContacts("David", 34512); // Should trigger resize

        assertEquals("[Alice: 12345, Bob: 54321, Charlie: 23451, David: 34512]", contactsList.getContacts());
        assertEquals(4, contactsList.getContactsArraySize()); // Check increased capacity
    }

    /**
     * Test sorting the contacts list.
     */
    public void testSortContacts() throws Exception {
        contactsList.addContacts("David", 34512);
        contactsList.addContacts("Alice", 12345);
        contactsList.addContacts("Charlie", 23451);
        
        // Verify order before sorting
        assertEquals("[David: 34512, Alice: 12345, Charlie: 23451]", contactsList.getContacts());

        // Sort contacts
        contactsList.sortContacts();

        // Verify order after sorting
        assertEquals("[Alice: 12345, Charlie: 23451, David: 34512]", contactsList.getContacts());

        // Print sorted contacts
        System.out.println("Sorted Contacts: " + contactsList.getContacts());
    }
}