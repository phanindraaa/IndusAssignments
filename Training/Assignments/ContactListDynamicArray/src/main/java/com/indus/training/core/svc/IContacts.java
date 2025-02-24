package com.indus.training.core.svc;

import java.io.IOException;

public interface IContacts {
	
    public void addContacts(String Name, int Contact) throws IOException;
    
    public void sortContacts();
    
    public String getContacts();
    
    public int getContactsArraySize();
}
