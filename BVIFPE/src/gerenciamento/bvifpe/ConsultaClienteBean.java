package gerenciamento.bvifpe;

import DAO.bvifpe.LivroDAO;
import DAO.bvifpe.UsuarioDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.bvifpe.Livro;
import modelo.bvifpe.Usuario;
import testes.bvifpe.LivroDAOTeste;

@ManagedBean
@ViewScoped
public class ConsultaClienteBean implements Serializable{
    
    List<Usuario> usuarios = new ArrayList<>();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Long codigo;
    
    public void consultaUsuarios() throws Exception{
        usuarios = usuarioDAO.listarUsuarios();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    
    
}