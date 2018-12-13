package gerenciamento.bvifpe;

import DAO.bvifpe.LivroDAO;
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
import testes.bvifpe.LivroDAOTeste;

@ManagedBean
@ViewScoped
public class ConsultaLivrosBean implements Serializable{
    
    List<Livro> livros = new ArrayList<>();
    Livro livroSelecionado = new Livro();
    LivroDAO livroDAO = new LivroDAO();
    Long codigo;
    
    public void consultaLivros() throws Exception{
        livros = livroDAO.listarLivros();
    }
    
    
    
    public void pesquisar(){
        livroSelecionado = livroDAO.listarLivrosPorCodigo(codigo);
        livros = null;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public Livro getLivroSelecionado() {
        return livroSelecionado;
    }

    public void setLivroSelecionado(Livro livroSelecionado) {
        this.livroSelecionado = livroSelecionado;
    }

    public LivroDAO getLivroDAO() {
        return livroDAO;
    }

    public void setLivroDAO(LivroDAO livroDAO) {
        this.livroDAO = livroDAO;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    
}