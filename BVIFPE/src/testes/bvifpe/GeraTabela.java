package testes.bvifpe;

import DAO.bvifpe.LivroDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.bvifpe.Livro;

import util.bvifpe.HibernateUtil;

public class GeraTabela {

	
	public static void main(String[] args) throws Exception {
                
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("bvifpePU");
		factory.close();
	}
}
