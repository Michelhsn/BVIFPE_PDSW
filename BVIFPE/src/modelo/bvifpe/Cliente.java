///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package modelo.bvifpe;
//
//import java.io.Serializable;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.DiscriminatorValue;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToOne;
//import javax.persistence.PrimaryKeyJoinColumn;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="TB_Cliente")
//@DiscriminatorValue(value="C")
//@PrimaryKeyJoinColumn(name="ID_USUARIO", referencedColumnName = "ID")
//@NamedQueries({@NamedQuery(name = "Cliente.listar", query = "SELECT c From Cliente c"),
//@NamedQuery(name = "Cliente.listarPorCodigo", query = "SELECT c From Cliente c WHERE c.id = :id")})
//public class Cliente extends Usuario implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//
//	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//	
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "FK_USUARIO", referencedColumnName = "ID")
//    private Usuario usuario;
//    
//    @Column(name = "NUM_DISPONIBILIDADE", nullable = false)
//    private Integer disponibilidade;
//    
//    @Column(name = "NUM_INADIMPLENTE", nullable = false)
//    private Integer inadimplente;
//    
//    @Column(name = "NUM_MULTA", nullable = false)
//    private Integer multa;
//
//    public Integer getDisponibilidade() {
//        return disponibilidade;
//    }
//
//    public void setDisponibilidade(Integer disponibilidade) {
//        this.disponibilidade = disponibilidade;
//    }
//
//    public Integer getInadimplente() {
//        return inadimplente;
//    }
//
//    public void setInadimplente(Integer inadimplente) {
//        this.inadimplente = inadimplente;
//    }
//
//    public Integer getMulta() {
//        return multa;
//    }
//
//    public void setMulta(Integer multa) {
//        this.multa = multa;
//    }
//    
//}
