package modelo.bvifpe;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Livro")
@NamedQueries({@NamedQuery(name = "Livro.listar", query = "SELECT l From Livro l"),
@NamedQuery(name = "Livro.listarPorCodigo", query = "SELECT l From Livro l WHERE l.id = :id")})
public class Livro implements Serializable{
    
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
   
    
    @Column(name= "TXT_TITULO")
    private String titulo;
    
    @Column(name= "TXT_EDITORA")
    private String editora;
    
    @Column(name= "TXT_AUTOR", nullable = true)
    private String autor;

    @Column(name= "TXT_ANO", nullable = true)
    private String ano;

    @Column(name= "TXT_CATEGORIA", nullable = true)
    private String categoria;
    
    @Column(name= "INT_CLASSIFICACAO", nullable = true)
    private String classificacao;
        
    @Column(name= "TXT_SINOPSE", nullable = true)
    private String sinopse;
            
    @Column(name= "QTD_estoque", nullable = true)
    private String estoque;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getEstoque() {
		return estoque;
	}

	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}
    
    
}
