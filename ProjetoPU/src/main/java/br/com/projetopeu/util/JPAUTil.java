package br.com.projetopeu.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUTil {

	private static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("ProjetoPU");

	public static EntityManager getEntityManager() {
		@SuppressWarnings("unused")
		EntityManager em = null;
		return	em = EMF.createEntityManager();
			
	}
}