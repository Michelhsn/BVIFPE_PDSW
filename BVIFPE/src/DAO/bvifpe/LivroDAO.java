package DAO.bvifpe;

import java.util.List;
import javax.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.bvifpe.Livro;
import sun.util.BuddhistCalendar;
import util.bvifpe.HibernateUtil;
import util.bvifpe.JPAUtil;

public class LivroDAO {

	public void salvarLivro(Livro livro) throws Exception{
		//Session sessao = HibernateUtil.getSessionFactory().openSession();
		EntityManager entityManager = JPAUtil.obterConexao();
		
		
		Transaction transacao = null;
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(livro);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			entityManager.close();
                        System.out.println("fechando");
		}
	}
	
	public List<Livro> listarLivros(){
		EntityManager entityManager = JPAUtil.obterConexao();
		
		List<Livro> livros = null;
		try{
			Query consulta = entityManager.createNamedQuery("Livro.listar");
			livros = consulta.getResultList();
		} catch(Exception ex){
		}finally{
                    
			entityManager.close();
                        System.out.println("fechando");
		}
		
		return livros;
	}
	
	public Livro listarLivrosPorCodigo(Long id){
		EntityManager entityManager = JPAUtil.obterConexao();
		Livro livro = null;
		try{
			Query consulta = entityManager.createNamedQuery("Livro.listarPorCodigo");
			consulta.setParameter("id", id);
			livro = (Livro) consulta.getSingleResult();
		} catch(Exception ex){
		}finally{
			entityManager.close();
                        System.out.println("fechando");
		}
		
		return livro;
	}
	
	public void excluirLivro(Livro livro) throws Exception{
		EntityManager entityManager = JPAUtil.obterConexao();
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entityManager.getReference(Livro.class, livro.getId()));
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			entityManager.close();
                        System.out.println("fechando");
		}
	}
	
	public void editarLivro(Livro livro) throws Exception{
		//Session sessao = HibernateUtil.getSessionFactory().openSession();
		EntityManager entityManager = JPAUtil.obterConexao();
		try {
			Livro livroEditado = listarLivrosPorCodigo(livro.getId());
			livroEditado.setAno(livro.getAno()); 
                        livroEditado.setAutor(livro.getAutor());
                        livroEditado.setEstoque(livro.getEstoque());
                        livroEditado.setTitulo(livro.getTitulo());
			entityManager.getTransaction().begin();
			entityManager.merge(livro);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			entityManager.close();
                        System.out.println("fechando");
		}
	}
	
}
