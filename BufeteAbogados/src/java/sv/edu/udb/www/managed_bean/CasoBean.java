/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.managed_bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import sv.edu.udb.www.entities.CasoEntity;
import sv.edu.udb.www.model.CasoModel;
import sv.edu.udb.www.utils.JsfUtil;

/**
 *
 * @author Kido
 */
@ManagedBean
@RequestScoped
public class CasoBean {
        CasoModel modelo = new CasoModel();
        private CasoEntity caso;
        private List<CasoEntity> listaCasos;
        
    
    public CasoBean() {
        caso = new CasoEntity();
    } //fin del constructor colaborador

    public CasoModel getModelo() {
        return modelo;
    }

    public void setModelo(CasoModel modelo) {
        this.modelo = modelo;
    }

    public CasoEntity getCaso() {
        return caso;
    }

    public void setCaso(CasoEntity caso) {
        this.caso = caso;
    }

    public List<CasoEntity> getListaCasos() {
        return modelo.listarCasos();
    }

    public void setListaCasos(List<CasoEntity> listaCasos) {
        this.listaCasos = listaCasos;
    }

   
    ///////////////// fin de los setter y getter 
    public String guardarCaso(){
    if(modelo.ingresarCaso(caso)!=1){
        modelo.modificarCaso(caso);
        return "caso?faces-redirect=true";
    
    }//fin if
    else{
        JsfUtil.setFlashMessage("exito","Caso registrado exitosamente");
            //forzando la redireccion en el cliente
            return "caso?faces-redirect=true";
    }
    }// fin del metodo guardar colaborador
    
   public String eliminarCaso(){
       //leyendo el parametro enviador desde la vista
       String identificador = JsfUtil.getRequest().getParameter("referencia");
       if(modelo.eliminarCaso(identificador)>0){
           JsfUtil.setFlashMessage("exito", "El caso ha sido eliminado");
       }//fin if
       else{
           JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo borrar el registro");
       }//fin else
       return "caso?faces-redirect=true";
   }//fin del metodo eliminar colaborador
    public void rellenarCampos(){
    }
}//fin de la clase caso bean
