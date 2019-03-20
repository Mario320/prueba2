/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.utils;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class JsfUtil {
    /*Este metodo permite definir un mensaje de error. 
    Recibe como parametro del id del control asociado al error 
    y el propio mensaje de error*/
    public static void setErrorMessage(String idClient, String msg){
        FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, msg,null);
            FacesContext.getCurrentInstance().addMessage(idClient, mensaje);
       
    }//fin del metodo seterror
    
    /*Este metodo permite definir un mensaje de tipo flash(mensaje que 
    se elimina de forma automatica  en cuanto una vista lo muestre*/
    public static void setFlashMessage(String name,String msg){
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put(name, msg);
    
    }//fin del metodo setFlash
    public static HttpServletRequest getRequest(){
        return(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }//fin del metodo estatico getrequest
}
