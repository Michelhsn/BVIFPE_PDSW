/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamento.bvifpe;

import DAO.bvifpe.UsuarioDAO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.bvifpe.Usuario;
import util.bvifpe.FacesUtil;

/**
 *
 * @author miche
 */

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
 
    private Usuario usuario;

    public Usuario getUsuario() {
        if (usuario == null){
        usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public void logar(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuario = usuarioDAO.autenticar(usuario.getLogin(), usuario.getSenha());
        
        if (usuario == null){
            FacesUtil.msgError("Login ou Senha incorretos!");
        }else{
            FacesUtil.msgError("Bem-Vindo");
        }
    }
}
