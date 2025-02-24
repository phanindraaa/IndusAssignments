package com.indus.training.persist.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

	private static EntityManagerFactory buildEntityManagerFactory() {
		// TODO Auto-generated method stub
		try {
			return Persistence.createEntityManagerFactory("myPersistJpa");
		} catch(Throwable ex){
			System.err.println("InitialEntity Manager Creation Failed"+ex);
			throw new ExceptionInInitializerError();
		}
	}
	
	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
		
	
		
	}
}
