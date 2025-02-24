package com.indus.training.core.impl;

import java.io.IOException;
import java.util.Arrays;

import com.indus.training.core.svc.IContacts;

public class ContactsList implements IContacts {

	static String[] contactsArray;
	public int initialSize;
	int Count = 0;
	public int remaining;

	public ContactsList(int initialSize) {
		contactsArray = new String[initialSize];
		this.initialSize = initialSize;
//		this.remaining = initialSize;
	}

	// Implementing the addContacts method from IContactsList
	@Override
	public void addContacts(String Name, int Contact) throws IOException{
			
			System.out.println(getContacts());
			System.out.println(Count);
			// Check if the array needs resizing
			if (String.valueOf(Contact).length() != 5) {
				throw new IOException ("Contact should be of length 5");
			}
			if (Count == contactsArray.length) {
				// Resize the array and copy existing elements
				String[] newArr = new String[Count + 1];
				System.arraycopy(contactsArray, 0, newArr, 0, contactsArray.length);
				contactsArray = newArr;
//				remaining = number;
			}

			// Add new contacts to the array
			contactsArray[Count] = Name+": "+String.valueOf(Contact);
			
			Count++;
//			remaining -= number; // Update remaining space
	}

	// Implementing the sortContacts method from IContactsList
	@Override
	public void sortContacts() {
		try {
			Arrays.sort(contactsArray, 0, Count); // Sort only the filled portion of the array
		} catch (Exception e) {
			System.out.println("Error while sorting the contacts: " + e.getMessage());
		}
	}

	// Implementing the getContacts method from IContactsList
	@Override
	public String getContacts() {
		return Arrays.toString(Arrays.copyOfRange(contactsArray, 0, Count));
	}

	// Implementing the getContactsArraySize method from IContactsList
	@Override
	public int getContactsArraySize() {
		return contactsArray.length;
	}

	// Main method for demonstration
	public static void main(String[] args) {
		try {
			ContactsList contacts = new ContactsList(1);
			contacts.addContacts("phani", 12345);
			contacts.addContacts("sai", 67890);
//			contacts.addContacts(new { "Ravi", "Sita", "Raju", "Lakshmi" });
//			contacts.addContacts(new String[] { "Krishna", "Gopal", "Vas", "Anjali" });
//			contacts.addContacts(new String[] { "Manjula", "Venkat" });
			System.out.println("Contacts: " + contacts.getContacts());
			contacts.sortContacts();
			System.out.println("Sorted Contacts: " + contacts.getContacts());
			System.out.println("Array size: "+ contacts.getContactsArraySize());
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}

}
