/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.bvifpe;

import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author miche
 */
public class FacesUtil {
    public static void msgInfo(String mensagem){
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
        
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    
    public static void msgError(String mensagem){
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
        
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    
    public static String getParam(String nome){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        
        Map<String,String> parametros = externalContext.getRequestParameterMap();
        
        String valor = parametros.get(nome);
        
        return valor;
    }
}
