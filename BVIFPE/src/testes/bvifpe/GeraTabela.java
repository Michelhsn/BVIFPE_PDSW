package testes.bvifpe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import util.bvifpe.HibernateUtil;

public class GeraTabela {

	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bvifpePU");
		factory.close();
	}
}
