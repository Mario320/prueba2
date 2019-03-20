/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.managed_bean;

import java.text.SimpleDateFormat;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import sv.edu.udb.www.entities.PoderEntity;
import sv.edu.udb.www.entities.ClienteEntity;
import sv.edu.udb.www.model.ClienteModel;
import sv.edu.udb.www.model.PoderModel;
import sv.edu.udb.www.utils.JsfUtil;
import sv.edu.udb.www.utils.SecurityUtils;

@ManagedBean
@RequestScoped
public class PoderBean {

    private PoderModel modelo = new PoderModel();
    private ClienteModel climo = new ClienteModel();
    private PoderEntity poder;
    private List<PoderEntity> listaPoderes;
    private List<ClienteEntity> listaClientes;

    public PoderBean() {
        poder = new PoderEntity();
    }

    public PoderModel getModelo() {
        return modelo;
    }

    public void setModelo(PoderModel modelo) {
        this.modelo = modelo;
    }

    public ClienteModel getClimo() {
        return climo;
    }

    public void setClimo(ClienteModel climo) {
        this.climo = climo;
    }

    public PoderEntity getPoder() {
        return poder;
    }

    public void setPoder(PoderEntity poder) {
        this.poder = poder;
    }

    public List<PoderEntity> getListaPoderes() {

        return modelo.listarPoderes();
    }

    public void setListaPoderes(List<PoderEntity> listaPoderes) {
        this.listaPoderes = listaPoderes;
    }

    public List<ClienteEntity> getListaClientes() {
        return climo.listarClientes();
    }

    public void setListaClientes(List<ClienteEntity> listaClientes) {
        this.listaClientes = listaClientes;
    }

    ///////////////// fin de los setter y getter 
    public String guardarPoder() {
        if(modelo.ingresarPoder(poder)!=1){
            
        modelo.modificarPoder(poder);
        JsfUtil.setFlashMessage("exito", "Poder reasignado exitosamente");
        return "poder?faces-redirect=true";
        

        }//fin if
        else{
        JsfUtil.setFlashMessage("exito","Poder asignado exitosamente");
        //forzando la redireccion en el poder
              return "poder?faces-redirect=true";
        }
    }// fin del metodo guardar poder

    public String eliminarPoder() {
        //leyendo el parametro enviador desde la vista
        String identificador = JsfUtil.getRequest().getParameter("idPoder");
        System.out.println(JsfUtil.getRequest().getParameter("idPoder"));
        if (modelo.eliminarPoder(identificador) > 0) {
            JsfUtil.setFlashMessage("exito", "El poder ha sido eliminado");
        }//fin if
        else {
            JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo borrar el registro");
        }//fin else
        return "poder?faces-redirect=true";
    }//fin del metodo eliminar colaborador

    public void rellenarCampos() {
    }
}//fin de la clase poder bean
