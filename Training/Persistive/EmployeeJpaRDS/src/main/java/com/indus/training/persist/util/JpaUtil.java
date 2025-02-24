package com.indus.training.persist.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        try {
            // Create the EntityManagerFactory from persistence.xml
            return Persistence.createEntityManagerFactory("EmployeePU");
        } catch (Throwable ex) {
            // Log the exception to help debugging
            System.err.println("Initial EntityManagerFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void shutdown() {
        // Close the EntityManagerFactory
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
