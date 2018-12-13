package testes.bvifpe;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import DAO.bvifpe.LivroDAO;
import modelo.bvifpe.Livro;

public class LivroDAOTeste {
	public void salvarLivroTeste() throws Exception{
		Livro livro = new Livro();
		livro.setAno("2000");
		
		LivroDAO dao = new LivroDAO();
		dao.salvarLivro(livro);
	}
	
	public void listar(){
		LivroDAO dao = new LivroDAO();
		List<Livro> livros = dao.listarLivros();
		
		for (Livro livro : livros){
			System.out.println(livro.getAno());
		}
		
	}
	
	public void listarPorCodigo(){
		LivroDAO dao = new LivroDAO();
		Livro livro = dao.listarLivrosPorCodigo(1L);
		
		System.out.println(livro.getAno() + " Por c�digo");
		
	}
	
	public void excluirLivro() throws Exception{
		LivroDAO dao = new LivroDAO();
		Livro livro = dao.listarLivrosPorCodigo(1L);
		
		dao.excluirLivro(livro);
	}
}
