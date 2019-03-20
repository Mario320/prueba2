/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.managed_bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import sv.edu.udb.www.entities.ClienteEntity;
import sv.edu.udb.www.model.ClienteModel;
import sv.edu.udb.www.utils.JsfUtil;

/**
 *
 * @author Kido
 */
@ManagedBean
@RequestScoped
public class ClienteBean {
        ClienteModel modelo = new ClienteModel();
        private ClienteEntity cliente;
        private List<ClienteEntity> listaClientes;
        
    
    public ClienteBean() {
        cliente = new ClienteEntity();
    } //fin del constructor colaborador

    public ClienteModel getModelo() {
        return modelo;
    }

    public void setModelo(ClienteModel modelo) {
        this.modelo = modelo;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public List<ClienteEntity> getListaClientes() {
        return modelo.listarClientes();
    }

    public void setListaClientes(List<ClienteEntity> listaClientes) {
        this.listaClientes = listaClientes;
    }

    
    ///////////////// fin de los setter y getter 
    public String guardarCliente(){
    if(modelo.ingresarCliente(cliente)!=1){
        modelo.modificarCliente(cliente);
        return "cliente?faces-redirect=true";
    
    }//fin if
    else{
        JsfUtil.setFlashMessage("exito","Colaborador registrado exitosamente");
            //forzando la redireccion en el cliente
            return "cliente?faces-redirect=true";
    }
    }// fin del metodo guardar colaborador
    
   public String eliminarCliente(){
       //leyendo el parametro enviador desde la vista
       String identificador = JsfUtil.getRequest().getParameter("idCliente");
       if(modelo.eliminarCliente(identificador)>0){
           JsfUtil.setFlashMessage("exito", "El cliente ha sido eliminado");
       }//fin if
       else{
           JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo borrar el registro");
       }//fin else
       return "cliente?faces-redirect=true";
   }//fin del metodo eliminar colaborador
    public void rellenarCampos(){
    }
}//fin de la clase colaborador bean
