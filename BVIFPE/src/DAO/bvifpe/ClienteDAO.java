package DAO.bvifpe;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.bvifpe.Cliente;
import sun.util.BuddhistCalendar;
import util.bvifpe.HibernateUtil;
import util.bvifpe.JPAUtil;

public class ClienteDAO {

	public void salvarCliente(Cliente cliente) throws Exception{
		EntityManager entityManager = JPAUtil.obterConexao();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(cliente);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			entityManager.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listarClientes(){
		EntityManager entityManager = JPAUtil.obterConexao();
		entityManager.getTransaction().begin();
		List<Cliente> clientes = null;
		try{
			Query consulta = entityManager.createNamedQuery("Cliente.listar");
			clientes = consulta.getResultList();
		} catch(Exception ex){
		}finally{
			entityManager.close();
		}
		
		return clientes;
	}
	
	@SuppressWarnings("unchecked")
	public Cliente listarClientesPorCodigo(Long id){
		EntityManager entityManager = JPAUtil.obterConexao();
		entityManager.getTransaction().begin();
		Cliente cliente = null;
		try{
			Query consulta = entityManager.createNamedQuery("Cliente.listarPorCodigo");
			consulta.setParameter("id", id);
			cliente = (Cliente) consulta.getSingleResult();
		} catch(Exception ex){
		}finally{
			entityManager.close();
		}
		
		return cliente;
	}
	
	public void excluirCliente(Cliente cliente) throws Exception{
		EntityManager entityManager = JPAUtil.obterConexao();
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entityManager.getReference(Cliente.class, cliente.getId()));
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			entityManager.close();
		}
	}
	
	public void editarCliente(Cliente cliente) throws Exception{
		EntityManager entityManager = JPAUtil.obterConexao();
		try {
			Cliente clienteEditado = listarClientesPorCodigo(cliente.getId());
			clienteEditado.setNome(cliente.getNome()); 
			entityManager.getTransaction().begin();
			entityManager.merge(clienteEditado);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			entityManager.close();
		}
	}
	
}
