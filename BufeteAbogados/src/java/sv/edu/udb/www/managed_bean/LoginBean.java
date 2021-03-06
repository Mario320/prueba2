
package sv.edu.udb.www.managed_bean;

import sv.edu.udb.www.entities.UsuarioEntity;
import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import sv.edu.udb.www.model.UsuariosModel;


@ManagedBean
@RequestScoped
public class LoginBean {

    UsuariosModel usuariosModel= new UsuariosModel();

    
    private UsuarioEntity user;
    
    public LoginBean() {
        user= new UsuarioEntity();
    }

    public UsuarioEntity getUser() {
        return user;
    }

    public void setUser(UsuarioEntity user) {
        this.user = user;
    }
    
    
    public String verificarCredenciales() throws Exception{
        System.out.println(user.getIdUsuario());
        System.out.println(user.getPassword());
        user= usuariosModel.checkLogin(user.getIdUsuario(), user.getPassword());
     
     if(user==null){ // Si las credenciales no son correctas...
         //Pasando mensaje de error a la vista
         FacesMessage message= new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                 "Credenciales incorrectas", null);
         FacesContext.getCurrentInstance().addMessage(null, message);
         // Redireccionando a la pagina actual
         return null;
     }
     else{ // si las credenciales son correctas
         //Obteniendo el request
         HttpServletRequest request= (HttpServletRequest) FacesContext
                 .getCurrentInstance().getExternalContext().getRequest();
         // Definiendo las variables de sesión
         request.getSession().setAttribute("usuario", user.getNombre());
         request.getSession().setAttribute("tipoUsuario", user.getIdTipoUsuario());
         return "bienvenidos"; // Redireccionando a la pagina bienvenido.xhtml
     }
    }
    
}
