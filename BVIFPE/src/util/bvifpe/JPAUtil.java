package util.bvifpe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;
	
	public static EntityManager obterConexao(){
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("bvifpePU");
		}
		entityManager = factory.createEntityManager();
		
		return entityManager;
	}
	
	public static void fecharConexao(){
		if (entityManager != null && entityManager.isOpen()) {
			entityManager.close();
		}
	}
}
