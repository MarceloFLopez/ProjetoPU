package util;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.projetopeu.util.JPAUTil;

public class JPAUtilTest {

	@SuppressWarnings("unused")
	@Test
	public void get() {
		EntityManager em = JPAUTil.getEntityManager();
	}
}
