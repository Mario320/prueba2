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
import sv.edu.udb.www.utils.JsfUtil;

/**
 *
 * @author Grismary
 */
@ManagedBean
@RequestScoped
public class UsuarioBean {

    UsuariosModel modelo = new UsuariosModel();
    private UsuarioEntity usu;
    private List<UsuarioEntity> listaUsuarios;

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

    
    public String guardarUsuario() {
        if (modelo.ingresarUsuarios(usu) != 1) {
            JsfUtil.setErrorMessage(null, "Ya se registró un usuario con este id");
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
        return "registroEstudiantes?faces-redirect=true";
    }

    
}
