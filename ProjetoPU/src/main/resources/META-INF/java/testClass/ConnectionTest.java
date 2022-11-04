package testClass;

import javax.persistence.EntityManager;

import br.com.projetopeu.util.JPAUTil;

public class ConnectionTest {

	public static void main(String[] args) {
		
		EntityManager em = JPAUTil.getEntityManager();
		System.out.println(em);
		em.close();
		System.out.println(em);
	}

}
