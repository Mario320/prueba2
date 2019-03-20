/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.managed_bean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import sv.edu.udb.www.entities.BitacoraEntity;

import sv.edu.udb.www.model.BitacoraModel;
import sv.edu.udb.www.entities.ColaboradorEntity;
import sv.edu.udb.www.entities.CasoEntity;
import sv.edu.udb.www.model.ColaboradorModel;
import sv.edu.udb.www.model.CasoModel;

import sv.edu.udb.www.utils.JsfUtil;


@ManagedBean
@RequestScoped
public class BitacoraBean {
        
        CasoModel caso = new CasoModel();
        ColaboradorModel colmod = new ColaboradorModel();
        
        private List<ColaboradorEntity> listaColaboradores;
        private List<CasoEntity> listaCasos;
        
        private BitacoraModel modelo = new BitacoraModel();
        private BitacoraEntity avance;
        private List<BitacoraEntity> bitacora;

    public CasoModel getCaso() {
        return caso;
    }

    public void setCaso(CasoModel caso) {
        this.caso = caso;
    }

    public ColaboradorModel getColmod() {
        return colmod;
    }

    public void setColmod(ColaboradorModel colmod) {
        this.colmod = colmod;
    }

    public List<ColaboradorEntity> getListaColaboradores() {
        return colmod.listarColaboradores();
    }

    public void setListaColaboradores(List<ColaboradorEntity> listaColaboradores) {
        this.listaColaboradores = listaColaboradores;
    }

    public List<CasoEntity> getListaCasos() {
        return caso.listarCasos();
    }

    public void setListaCasos(List<CasoEntity> listaCasos) {
        this.listaCasos = listaCasos;
    }
        
        
        
    
    public BitacoraBean() {
       avance = new BitacoraEntity();
    } //fin del constructor colaborador

    public BitacoraModel getModelo() {
        return modelo;
    }

    
    
    public void setModelo(BitacoraModel modelo) {
        this.modelo = modelo;
    }

    public BitacoraEntity getAvance() {
        return avance;
    }

    public void setAvance(BitacoraEntity avance) {
        this.avance = avance;
    }

    public List<BitacoraEntity> getBitacora() {
        HttpServletRequest request= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String referencia= request.getParameter("referencia");
        return modelo.encontrarAvance(referencia);
    }

    public void setBitacora(List<BitacoraEntity> bitacora) {
        this.bitacora = bitacora;
    }
    
    
     public String encontrarReferencia() {
        HttpServletRequest request= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String referencia= request.getParameter("referencia");
        return referencia;
    }

   
    
    ///////////////// fin de los setter y getter 
    public String guardarAvance(){
        
                
    if(modelo.ingresarAvance(avance)!=1){
        modelo.modificarAvance(avance);
        return "bitacora?faces-redirect=true";
    
    }//fin if
    else{
        JsfUtil.setFlashMessage("exito","avance registrado exitosamente");
            //forzando la redireccion en el cliente
            return "bitacora?faces-redirect=true";
    }
    }// fin del metodo guardar colaborador
    
   public String eliminarAvance(){
       //leyendo el parametro enviador desde la vista
       String identificador = JsfUtil.getRequest().getParameter("idBitacora");
       if(modelo.eliminarAvance(identificador)>0){
           JsfUtil.setFlashMessage("exito", "El caso ha sido eliminado");
       }//fin if
       else{
           JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo borrar el registro");
       }//fin else
       return "regbitacora?faces-redirect=true";
   }//fin del metodo eliminar colaborador
   
   
      public String llenarB(){
       HttpServletRequest request= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String referencia= request.getParameter("referencia");
        avance= modelo.encontrarReferencia(referencia);
       return "bitacora";
   }
   
   
   
 
   
}//fin de la clase bitacora bean
