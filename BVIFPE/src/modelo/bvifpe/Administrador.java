///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package modelo.bvifpe;
//
//import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.DiscriminatorValue;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.PrimaryKeyJoinColumn;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name="TB_Administrador")
//@DiscriminatorValue(value="A")
//@PrimaryKeyJoinColumn(name="ID_USUARIO", referencedColumnName = "ID")
//public class Administrador extends Usuario implements Serializable {
//    
//    /**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "FK_USUARIO", referencedColumnName="ID")
//	private Usuario usuario;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}
//     
//    
//    
//}
