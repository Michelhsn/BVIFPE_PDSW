/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamento.bvifpe;

import DAO.bvifpe.UsuarioDAO;
import DAO.bvifpe.UsuarioDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.bvifpe.Usuario;
import modelo.bvifpe.Usuario;
import util.bvifpe.FacesUtil;

/**
 *
 * @author miche
 */


@ManagedBean
@ViewScoped
public class CadastroClientesBean {
    
    private String nome;
    private String cpf;
    private String email;
    private String login;
    private String senha;
    private Long id;
    private String acao;
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Usuario usuario = new Usuario();
    
    public void salvar() throws Exception{
        usuario.setNome(nome);
        usuario.setCpf(cpf);
        usuario.setEmail(email);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuarioDAO.salvarUsuario(usuario);
        nome = null;
        cpf = null;
        email = null;
        login = null;
        senha = null;
        FacesUtil.msgInfo("Usuario Adicionado Com Sucesso!!");
        usuario = new Usuario();
        
    }
    
    public void editar() throws Exception{
        usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setCpf(cpf);
        usuario.setEmail(email);
        usuario.setLogin(login);
        usuario.setId(id);
        usuarioDAO.editarUsuario(usuario);
        nome = null;
        cpf = null;
        email = null;
        login = null;
        FacesUtil.msgInfo("Usuario Alterado Com Sucesso!!");
    }
    
    public void excluir() throws Exception{
        usuario.setNome(nome);
        usuario.setCpf(cpf);
        usuario.setLogin(login);
        usuario.setEmail(email);
        usuario.setId(id);
        usuarioDAO.excluirUsuario(usuario);
        nome = null;
        cpf = null;
        login = null;
        email = null;
        FacesUtil.msgInfo("Usuario Excluído Com Sucesso!!");
        usuario = new Usuario();
        
    }
    
    public void carregaCadastro(){
        String valor = FacesUtil.getParam("cod");
        acao = FacesUtil.getParam("acao");
        if (valor != null){
            Long cod = Long.parseLong(valor);
            
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuario = usuarioDAO.listarUsuariosPorCodigo(cod);
            nome = usuario.getNome();
            cpf = usuario.getCpf();
            email = usuario.getEmail();
            login = usuario.getLogin();
            id = usuario.getId();
            
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
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

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
