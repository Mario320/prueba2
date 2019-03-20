/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.managed_bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import sv.edu.udb.www.entities.ColaboradorCasoEntity;
import sv.edu.udb.www.model.ColCasoModel;
import sv.edu.udb.www.utils.JsfUtil;

/**
 *
 * @author Kido
 */
@ManagedBean
@RequestScoped
public class ColCasoBean {
        ColCasoModel modelo = new ColCasoModel();
        private ColaboradorCasoEntity colcaso;
        private List<ColaboradorCasoEntity> listaColCasos;
        
    
    public ColCasoBean() {
        colcaso = new ColaboradorCasoEntity();
    } //fin del constructor colaborador

    public ColCasoModel getModelo() {
        return modelo;
    }

    public void setModelo(ColCasoModel modelo) {
        this.modelo = modelo;
    }

    public ColaboradorCasoEntity getColcaso() {
        return colcaso;
    }

    public void setColcaso(ColaboradorCasoEntity colcaso) {
        this.colcaso = colcaso;
    }

    public List<ColaboradorCasoEntity> getListaColCasos() {
        return modelo.listarColCasos();
    }

    public void setListaColCasos(List<ColaboradorCasoEntity> listaColCasos) {
        this.listaColCasos = listaColCasos;
    }

    
    ///////////////// fin de los setter y getter 
    public String guardarColCaso(){
    if(modelo.ingresarColCaso(colcaso)!=1){
        modelo.modificarColCaso(colcaso);
        return "colcaso?faces-redirect=true";
    
    }//fin if
    else{
        JsfUtil.setFlashMessage("exito","Caso asignado exitosamente");
            //forzando la redireccion en el cliente
            return "colcaso?faces-redirect=true";
    }
    }// fin del metodo guardar colaborador
    
   public String eliminarColCaso(){
       //leyendo el parametro enviador desde la vista
       String identificador = JsfUtil.getRequest().getParameter("referencia");
       if(modelo.eliminarColCaso(identificador)>0){
           JsfUtil.setFlashMessage("exito", "El caso ha sido eliminado");
       }//fin if
       else{
           JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo borrar el registro");
       }//fin else
       return "colcaso?faces-redirect=true";
   }//fin del metodo eliminar colaborador
    public void rellenarCampos(){
    }
}//fin de la clase caso bean
