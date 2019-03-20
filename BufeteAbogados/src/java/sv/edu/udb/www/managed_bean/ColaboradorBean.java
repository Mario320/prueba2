/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.managed_bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import sv.edu.udb.www.entities.ColaboradorEntity;
import sv.edu.udb.www.model.ColaboradorModel;
import sv.edu.udb.www.utils.JsfUtil;

/**
 *
 * @author Kido
 */
@ManagedBean
@RequestScoped
public class ColaboradorBean {
        ColaboradorModel modelo = new ColaboradorModel();
        private ColaboradorEntity colaborador;
        private List<ColaboradorEntity> listaColaboradores;
        
    
    public ColaboradorBean() {
        colaborador = new ColaboradorEntity();
    } //fin del constructor colaborador

    public ColaboradorModel getModelo() {
        return modelo;
    }

    public void setModelo(ColaboradorModel modelo) {
        this.modelo = modelo;
    }

    public ColaboradorEntity getColaborador() {
        return colaborador;
    }

    public void setColaborador(ColaboradorEntity colaborador) {
        this.colaborador = colaborador;
    }

    public List<ColaboradorEntity> getListaColaboradores() {
        /*Notese que se llama al metodo listarColaboradores
      para obtener la lista de objetos a partir de la bd*/
        return modelo.listarColaboradores();
    }

    public void setListaColaboradores(List<ColaboradorEntity> listaColaboradores) {
        this.listaColaboradores = listaColaboradores;
    }
    ///////////////// fin de los setter y getter 
    public String guardarColaborador(){
    if(modelo.ingresarColaborador(colaborador)!=1){
        modelo.modificarColaborador(colaborador);
        return "colaborador?faces-redirect=true";
    
    }//fin if
    else{
        JsfUtil.setFlashMessage("exito","Colaborador registrado exitosamente");
            //forzando la redireccion en el cliente
            return "colaborador?faces-redirect=true";
    }
    }// fin del metodo guardar colaborador
    
   public String eliminarColaborador(){
       //leyendo el parametro enviador desde la vista
       String identificador = JsfUtil.getRequest().getParameter("idColaborador");
       if(modelo.eliminarColaborador(identificador)>0){
           JsfUtil.setFlashMessage("exito", "El colaborador ha sido eliminado");
       }//fin if
       else{
           JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo borrar el registro");
       }//fin else
       return "colaborador?faces-redirect=true";
   }//fin del metodo eliminar colaborador
    public void rellenarCampos(){
    }
}//fin de la clase colaborador bean
