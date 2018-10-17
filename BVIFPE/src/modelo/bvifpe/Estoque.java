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
import javax.persistence.Table;

@Entity
@Table(name = "TB_ESTOQUE")
public class Estoque implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "NUM_CODIGO_LIVRO")
	private String codLivro;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_LIVRO", referencedColumnName = "ID")
	private Livro livro;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_USUARIO", referencedColumnName = "ID")
	private Usuario usuario;
	
	
}
