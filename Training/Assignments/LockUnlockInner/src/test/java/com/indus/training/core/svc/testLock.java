package com.indus.training.core.svc;

import com.indus.training.core.impl.Lock;

import junit.framework.TestCase;

public class testLock extends TestCase {
    
    // Test to verify the initial state of the lock
    public void testInitialLockState() {
        Lock lock = new Lock(1234); 
        assertTrue(lock.isLocked());     }

    // Test to verify unlocking the lock with the correct key
    public void testUnlockWithCorrectKey() {
        Lock lock = new Lock(1234);
        Lock.Key key = lock.new Key(1234); 
        assertTrue(key.unlockLock(lock)); 
        assertFalse(lock.isLocked()); 
    }

    // Test to verify unlocking the lock with an incorrect key
    public void testUnlockWithIncorrectKey() {
        Lock lock = new Lock(1234); 
        Lock.Key key = lock.new Key(5678); 
        assertFalse(key.unlockLock(lock)); 
        assertTrue(lock.isLocked());
    }

    // Test to verify the sequence of locking and unlocking the lock
    public void testLockAndUnlockSequence() {
        Lock lock = new Lock(1234); 

        
        lock.lockM(); 
        assertTrue(lock.isLocked()); 
    }
}
