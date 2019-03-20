/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.managed_bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import sv.edu.udb.www.entities.PoderEntity;
import sv.edu.udb.www.model.PoderModel;
import sv.edu.udb.www.utils.JsfUtil;


@ManagedBean
@RequestScoped
public class PoderBean {
        PoderModel modelo = new PoderModel();
        private PoderEntity poder;
        private List<PoderEntity> listaPoderes;
        
    
    public PoderBean() {
        poder = new PoderEntity();
    } //fin del constructor Poder

    public PoderModel getModelo() {
        return modelo;
    }

    public void setModelo(PoderModel modelo) {
        this.modelo = modelo;
    }

    public PoderEntity getPoderes() {
        return poder;
    }

    public void setPoderes(PoderEntity poder) {
        this.poder = poder;
    }

    public List<PoderEntity> getListaPoderes() {
        return modelo.listarPoderes();
    }

    public void setListaPoderes(List<PoderEntity> listaPoderes) {
        this.listaPoderes = listaPoderes;
    }

    
    
    ///////////////// fin de los setter y getter 
    public String guardarPoder(){
    if(modelo.ingresarPoder(poder)!=1){
        modelo.modificarPoder(poder);
        return "poder?faces-redirect=true";
    
    }//fin if
    else{
        JsfUtil.setFlashMessage("exito","Poder asignado exitosamente");
            //forzando la redireccion en el poder
            return "poder?faces-redirect=true";
    }
    }// fin del metodo guardar poder
    
   public String eliminarPoder(){
       //leyendo el parametro enviador desde la vista
       String identificador = JsfUtil.getRequest().getParameter("idPoder");
       if(modelo.eliminarPoder(identificador)>0){
           JsfUtil.setFlashMessage("exito", "El poder ha sido eliminado");
       }//fin if
       else{
           JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo borrar el registro");
       }//fin else
       return "poder?faces-redirect=true";
   }//fin del metodo eliminar colaborador
    public void rellenarCampos(){
    }
}//fin de la clase poder bean
