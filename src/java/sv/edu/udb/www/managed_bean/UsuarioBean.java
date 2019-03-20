/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.managed_bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sv.edu.udb.www.entities.UsuarioEntity;
import sv.edu.udb.www.model.UsuariosModel;
import sv.edu.udb.www.entities.TipousuarioEntity;
import sv.edu.udb.www.model.TipousuariosModel;
import sv.edu.udb.www.utils.JsfUtil;
import sv.edu.udb.www.utils.SecurityUtils;


@ManagedBean
@RequestScoped

public class UsuarioBean {

   private UsuariosModel modelo = new UsuariosModel();
   private UsuarioEntity usu;
    private List<UsuarioEntity> listaUsuarios;
   private List<TipousuarioEntity>listaTipos;
   private TipousuariosModel tipomodel= new TipousuariosModel();
    /**
     * Creates a new instance of UsuarioBean
     */
   
    public UsuarioBean() {
        usu = new UsuarioEntity();
    }

    public UsuariosModel getModelo() {
        return modelo;
    }

    public void setModelo(UsuariosModel modelo) {
        this.modelo = modelo;
    }

    public UsuarioEntity getUsu() {
        return usu;
    }

    public void setUsu(UsuarioEntity usu) {
        this.usu = usu;
    }

    public List<UsuarioEntity> getListaUsuarios() {
         return modelo.listarUsuarios();
    }

    public void setListaUsuarios(List<UsuarioEntity> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<TipousuarioEntity> getListaTipos() {
        return tipomodel.listarTipos();
    }

    public void setListaTipos(List<TipousuarioEntity> listaTipos) {
        this.listaTipos = listaTipos;
    }
    
    
    public String guardarUsuario() throws Exception {
        
                usu.setPassword(SecurityUtils.encriptarSHA(usu.getPassword()));
                 
        if (modelo.ingresarUsuarios(usu) != 1) {
            modelo.modificarUsuarios(usu);
             JsfUtil.setFlashMessage("exito", "Usuario modificado exitosamente");
            return null;//Regreso a la misma página
        } else {
            JsfUtil.setFlashMessage("exito", "Usuario registrado exitosamente");
            //Forzando la redirección en el cliente
            return "usuarios?faces-redirect=true";
        }
    }

    public String eliminarUsuario() {
        // Leyendo el parametro enviado desde la vista
        String IdUsuario = JsfUtil.getRequest().getParameter("IdUsuario");

        if (modelo.eliminarUsuarios(IdUsuario) > 0) {
            JsfUtil.setFlashMessage("exito", "Usuario eliminado exitosamente  ");
        } else {
            JsfUtil.setErrorMessage(null, "No se pudo borrar a este usuario");
        }
        return "usuarios?faces-redirect=true";
    }

    
}
