package br.com.projetopeu.util;

import javax.persistence.EntityManager;

public class TesteConnection {

	public static void main(String[] args) {
		
		EntityManager em = JPAUTil.getEntityManager();
		System.out.println(em);
		em.close();
		System.out.println(em);
	}
}
