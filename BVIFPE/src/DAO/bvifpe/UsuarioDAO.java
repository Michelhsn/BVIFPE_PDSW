package DAO.bvifpe;

import java.util.List;
import javax.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.bvifpe.Usuario;
import sun.util.BuddhistCalendar;
import util.bvifpe.HibernateUtil;
import util.bvifpe.JPAUtil;

public class UsuarioDAO {

	public void salvarUsuario(Usuario usuario) throws Exception{
		//Session sessao = HibernateUtil.getSessionFactory().openSession();
		EntityManager entityManager = JPAUtil.obterConexao();
		
		
		Transaction transacao = null;
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(usuario);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			entityManager.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarios(){
		EntityManager entityManager = JPAUtil.obterConexao();
		List<Usuario> usuarios = null;
		try{
			Query consulta = entityManager.createNamedQuery("Usuario.listar");
			usuarios = consulta.getResultList();
		} catch(Exception ex){
		}finally{
			entityManager.close();
		}
		
		return usuarios;
	}
	
	@SuppressWarnings("unchecked")
	public Usuario listarUsuariosPorCodigo(Long id){
		EntityManager entityManager = JPAUtil.obterConexao();
		Usuario usuario = null;
		try{
			Query consulta = entityManager.createNamedQuery("Usuario.listarPorCodigo");
			consulta.setParameter("id", id);
			usuario = (Usuario) consulta.getSingleResult();
		} catch(Exception ex){
		}finally{
			entityManager.close();
		}
		
		return usuario;
	}
        
        public Usuario autenticar(String login, String senha){
		EntityManager entityManager = JPAUtil.obterConexao();
		Usuario usuario = null;
		try{
			Query consulta = entityManager.createNamedQuery("Usuario.autenticar");
			consulta.setParameter("login", login);
                        consulta.setParameter("senha", senha);
			usuario = (Usuario) consulta.getSingleResult();
		} catch(Exception ex){
		}finally{
			entityManager.close();
		}
		
		return usuario;
	}
	
	public void excluirUsuario(Usuario usuario) throws Exception{
		EntityManager entityManager = JPAUtil.obterConexao();
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entityManager.getReference(Usuario.class, usuario.getId()));
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			entityManager.close();
		}
	}
	
	public void editarUsuario(Usuario usuario) throws Exception{
		//Session sessao = HibernateUtil.getSessionFactory().openSession();
		EntityManager entityManager = JPAUtil.obterConexao();
		try {
			Usuario usuarioEditado = listarUsuariosPorCodigo(usuario.getId());
			usuarioEditado.setCpf(usuario.getCpf()); 
                        usuarioEditado.setEmail(usuario.getEmail());
                        usuarioEditado.setId(usuario.getId());
                        usuarioEditado.setLogin(usuario.getLogin());
                        usuarioEditado.setNome(usuario.getNome());
			entityManager.getTransaction().begin();
			entityManager.merge(usuarioEditado);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			entityManager.close();
		}
	}
	
}
