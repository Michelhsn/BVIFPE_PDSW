/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamento.bvifpe;

import DAO.bvifpe.LivroDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.bvifpe.Livro;
import util.bvifpe.FacesUtil;

/**
 *
 * @author miche
 */


@ManagedBean
@ViewScoped
public class CadastroLivroBean {
    
    private String autor;
    private String ano;
    private String titulo;
    private Integer estoque;
    private Long id;
    private String acao;
    LivroDAO livroDAO = new LivroDAO();
    Livro livro = new Livro();
    
    public void salvar() throws Exception{
        livro.setAno(ano);
        livro.setAutor(autor);
        livro.setEstoque(estoque);
        livro.setTitulo(titulo);
        livroDAO.salvarLivro(livro);
        ano = null;
        autor = null;
        titulo = null;
        estoque = null;
        FacesUtil.msgInfo("Livro Adicionado Com Sucesso!!");
        livro = new Livro();
        
    }
    
    public void editar() throws Exception{
        livro = new Livro();
        livro.setAno(ano);
        livro.setAutor(autor);
        livro.setEstoque(estoque);
        livro.setTitulo(titulo);
        livro.setId(id);
        livroDAO.editarLivro(livro);
        ano = null;
        autor = null;
        titulo = null;
        estoque = null;
        FacesUtil.msgInfo("Livro Alterado Com Sucesso!!");
        
        
    }
    
    public void excluir() throws Exception{
        livro.setAno(ano);
        livro.setAutor(autor);
        livro.setEstoque(estoque);
        livro.setTitulo(titulo);
        livro.setId(id);
        livroDAO.excluirLivro(livro);
        ano = null;
        autor = null;
        titulo = null;
        estoque = null;
        FacesUtil.msgInfo("Livro Excluído Com Sucesso!!");
        livro = new Livro();
        
    }
    
    public void carregaCadastro(){
        String valor = FacesUtil.getParam("cod");
        acao = FacesUtil.getParam("acao");
        if (valor != null){
            Long cod = Long.parseLong(valor);
            
            LivroDAO livroDAO = new LivroDAO();
            livro = livroDAO.listarLivrosPorCodigo(cod);
            ano = livro.getAno();
            autor = livro.getAutor();
            titulo = livro.getTitulo();
            estoque = livro.getEstoque();
            id = livro.getId();
            
        }
    }
    
    public void emprestar() throws Exception{
        String valor = FacesUtil.getParam("cod");
        acao = FacesUtil.getParam("acao");
        if (valor != null){
            Long cod = Long.parseLong(valor);
            
            LivroDAO livroDAO = new LivroDAO();
            livro = livroDAO.listarLivrosPorCodigo(cod);
            if (livro.getEstoque() < 1){
                FacesUtil.msgInfo("Este livro não está disponível");
            }else{
                livro.setEstoque(livro.getEstoque() - 1);
               livroDAO.editarLivro(livro);
            FacesUtil.msgInfo("O empréstimo do livro " + livro.getTitulo() + " foi registrado"); 
            }
                
            
            
        }
    }
    
    public void devolver() throws Exception{
        String valor = FacesUtil.getParam("cod");
        acao = FacesUtil.getParam("acao");
        if (valor != null){
            Long cod = Long.parseLong(valor);
            
            LivroDAO livroDAO = new LivroDAO();
            livro = livroDAO.listarLivrosPorCodigo(cod);
            livro.setEstoque(livro.getEstoque() + 1);
            livroDAO.editarLivro(livro);
            FacesUtil.msgInfo("O livro " + livro.getTitulo() + " foi devolvido"); 
        }
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }
    
    
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
    
    
}
