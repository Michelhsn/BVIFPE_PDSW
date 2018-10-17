package testes.bvifpe;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class Teste {

	@Test
	public void gerar(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bvifpePU");
		//EntityManager entityManager = factory.createEntityManager();
		factory.close();
	}
}
