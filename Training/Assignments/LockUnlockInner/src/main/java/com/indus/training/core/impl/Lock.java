package com.indus.training.core.impl;

public class Lock {
    private boolean locked; 
    private int keyId;    
    
    // Constructor to initialize the lock with a specific keyId and set it as locked
    public Lock(int keyId) {
        this.keyId = keyId;
        this.locked = true; 
    }

    // Method to check if the lock is currently locked
    public boolean isLocked() {
        return locked;
    }

    // Method to lock the lock
    public void lockM() {
        this.locked = true;
    }

    // Method to unlock the lock using a key
    public boolean unlock(Key key) {
        if (key.getKeyId() == this.keyId) { 
            this.locked = false;
            return true;
        } else {
            return false; 
        }
    }

    // Inner Key class
    public class Key {
        private int keyId; // Unique identifier for this key

        // Constructor to initialize the key with a specific keyId
        public Key(int keyId) {
            this.keyId = keyId;
        }

        // Method to get the keyId of this key
        private int getKeyId() {
            return keyId;
        }

        // Method to unlock a lock using this key
        public boolean unlockLock(Lock lock) {
            return lock.unlock(this);
        }
    }
}
