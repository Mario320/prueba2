/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Kido
 */
@Entity
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "ClienteEntity.findAll", query = "SELECT c FROM ClienteEntity c")
    , @NamedQuery(name = "ClienteEntity.findByIdCliente", query = "SELECT c FROM ClienteEntity c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "ClienteEntity.findByDi", query = "SELECT c FROM ClienteEntity c WHERE c.di = :di")
    , @NamedQuery(name = "ClienteEntity.findByNombre", query = "SELECT c FROM ClienteEntity c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "ClienteEntity.findByApellido", query = "SELECT c FROM ClienteEntity c WHERE c.apellido = :apellido")
    , @NamedQuery(name = "ClienteEntity.findByRepresentanteLegal", query = "SELECT c FROM ClienteEntity c WHERE c.representanteLegal = :representanteLegal")
    , @NamedQuery(name = "ClienteEntity.findByIdPoder", query = "SELECT c FROM ClienteEntity c WHERE c.idPoder = :idPoder")
    , @NamedQuery(name = "ClienteEntity.findByCorreo", query = "SELECT c FROM ClienteEntity c WHERE c.correo = :correo")
    , @NamedQuery(name = "ClienteEntity.findByTelefono", query = "SELECT c FROM ClienteEntity c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "ClienteEntity.findByDireccion", query = "SELECT c FROM ClienteEntity c WHERE c.direccion = :direccion")})
public class ClienteEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String idCliente;
    @Basic(optional = false)
    private String di;
    private String nombre;
    private String apellido;
    private String representanteLegal;
    private String idPoder;
    private String correo;
    private String telefono;
    private String direccion;

    public ClienteEntity() {
    }

    public ClienteEntity(String idCliente) {
        this.idCliente = idCliente;
    }

    public ClienteEntity(String idCliente, String di) {
        this.idCliente = idCliente;
        this.di = di;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getDi() {
        return di;
    }

    public void setDi(String di) {
        this.di = di;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getIdPoder() {
        return idPoder;
    }

    public void setIdPoder(String idPoder) {
        this.idPoder = idPoder;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteEntity)) {
            return false;
        }
        ClienteEntity other = (ClienteEntity) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.ClienteEntity[ idCliente=" + idCliente + " ]";
    }
    
}
