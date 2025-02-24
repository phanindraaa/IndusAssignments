package com.indus.training.core.impl;

import com.indus.training.core.svc.SubjectManager;

// Implementation of the SubjectManager interface.
public class SubjectManagerImpl implements SubjectManager {
    private String[] subjects;
    private int count;

    // Constructor to initialize the array and count
    public SubjectManagerImpl() {
        subjects = new String[10]; // Initial capacity of 10
        count = 0;
    }

    // Adds a subject to the array.
    public void addSubject(String subject) {
        if (count < subjects.length) {
            subjects[count] = subject;
            count++;
        } else {
            System.out.println("Array is full, cannot add more subjects.");
        }
    }

    // Lists all subjects.
    public String listSubjects() {
        if (count == 0) {
            return "No subjects available";
        }
        String result = "";
        for (int i = 0; i < count; i++) {
            result += subjects[i] + "\n";
        }
        return result;
    }
}
