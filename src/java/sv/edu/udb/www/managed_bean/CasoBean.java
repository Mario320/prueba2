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
import sv.edu.udb.www.entities.ClienteEntity;
import sv.edu.udb.www.entities.CasoEntity;
import sv.edu.udb.www.model.ClienteModel;
import sv.edu.udb.www.model.CasoModel;
import sv.edu.udb.www.utils.JsfUtil;


@ManagedBean
@RequestScoped
public class CasoBean {
        private  CasoModel modelo = new CasoModel();
        private CasoEntity caso;
        private List<CasoEntity> listaCasos;
        private List<ClienteEntity>listaClientes;
        private ClienteModel climo=new ClienteModel();

    public List<ClienteEntity> getListaClientes() {
        return climo.listarClientes();
    }

    public void setListaClientes(List<ClienteEntity> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ClienteModel getClimo() {
        return climo;
    }

    public void setClimo(ClienteModel climo) {
        this.climo = climo;
    }
    
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
        JsfUtil.setFlashMessage("exito","Caso modificado exitosamente");
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
       return "listac?faces-redirect=true";
   }//fin del metodo eliminar colaborador
    public void rellenarCampos(){
    }
    
//     public String llenar(){
//       HttpServletRequest request= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        String referencia= request.getParameter("referencia");
//        caso= modelo.encontrarReferencia(referencia);
//       return "bitacora";
//   }
    
}//fin de la clase caso bean
