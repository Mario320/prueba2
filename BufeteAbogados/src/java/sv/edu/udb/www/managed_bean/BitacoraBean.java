/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.managed_bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import sv.edu.udb.www.entities.BitacoraEntity;
import sv.edu.udb.www.model.BitacoraModel;
import sv.edu.udb.www.utils.JsfUtil;

/**
 *
 * @author Kido
 */
@ManagedBean
@RequestScoped
public class BitacoraBean {
        BitacoraModel modelo = new BitacoraModel();
        private BitacoraEntity bit;
        private List<BitacoraEntity> ListarBitacora;
        
    
    public BitacoraBean() {
        bit = new BitacoraEntity();
    } //fin del constructor colaborador

    public BitacoraModel getModelo() {
        return modelo;
    }

    public void setModelo(BitacoraModel modelo) {
        this.modelo = modelo;
    }

    public BitacoraEntity getBit() {
        return bit;
    }

    public void setBit(BitacoraEntity bit) {
        this.bit = bit;
    }

    public List<BitacoraEntity> getListarBitacora() {
        return modelo.listarAvances();
    }

    public void setListarBitacora(List<BitacoraEntity> bitacora) {
        this.ListarBitacora = bitacora;
    }

    
   
    ///////////////// fin de los setter y getter 
    public String guardarAvance(){
    if(modelo.ingresarAvance(bit)!=1){
        modelo.modificarAvance(bit);
        return "bitacora?faces-redirect=true";
    
    }//fin if
    else{
        JsfUtil.setFlashMessage("exito","Avance registrado exitosamente");
            //forzando la redireccion en el cliente
            return "bitacora?faces-redirect=true";
    }
    }// fin del metodo guardar colaborador
    
   public String eliminarAvance(){
       //leyendo el parametro enviador desde la vista
       String identificador = JsfUtil.getRequest().getParameter("referencia");
       if(modelo.eliminarAvance(identificador)>0){
           JsfUtil.setFlashMessage("exito", "El avance ha sido eliminado");
       }//fin if
       else{
           JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo borrar el registro");
       }//fin else
       return "bitacora?faces-redirect=true";
   }//fin del metodo eliminar colaborador
    
     public void rellenarCampos(){
    } 
   
}//fin de la clase bitacora bean
