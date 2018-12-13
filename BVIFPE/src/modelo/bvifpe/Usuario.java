/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bvifpe;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Usuario")
//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "DISC_Usuario",
//        discriminatorType = DiscriminatorType.STRING, length = 1)
//@Access(AccessType.FIELD)
@NamedQueries({@NamedQuery(name = "Usuario.listar", query = "SELECT u From Usuario u"),
@NamedQuery(name = "Usuario.listarPorCodigo", query = "SELECT u From Usuario u WHERE u.id = :id"),
@NamedQuery(name = "Usuario.autenticar", query = "SELECT u From Usuario u WHERE u.login = :login AND u.senha=:senha")})
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "FK_ENDERECO", referencedColumnName = "ID")
//	private Endereco endereco;
	
    @Column(name = "TXT_NOME")
    private String nome;

    @Column(name = "TXT_RG")
    private String rg;
    
    @Column(name = "TXT_CPF")
    private String cpf;
    
    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;
    
    @Column(name = "TXT_EMAIL")
    private String email;
        
    @Column(name = "TXT_LOGIN")
    private String login;
            
    @Column(name = "TXT_SENHA")
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
