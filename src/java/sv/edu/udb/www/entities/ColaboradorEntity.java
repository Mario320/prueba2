/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kido
 */
@Entity
@Table(name = "colaborador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ColaboradorEntity.findAll", query = "SELECT c FROM ColaboradorEntity c")
    , @NamedQuery(name = "ColaboradorEntity.findByIdColaborador", query = "SELECT c FROM ColaboradorEntity c WHERE c.idColaborador = :idColaborador")
    , @NamedQuery(name = "ColaboradorEntity.findByNombre", query = "SELECT c FROM ColaboradorEntity c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "ColaboradorEntity.findByApellido", query = "SELECT c FROM ColaboradorEntity c WHERE c.apellido = :apellido")
    , @NamedQuery(name = "ColaboradorEntity.findByCorreo", query = "SELECT c FROM ColaboradorEntity c WHERE c.correo = :correo")
    , @NamedQuery(name = "ColaboradorEntity.findByTelefono", query = "SELECT c FROM ColaboradorEntity c WHERE c.telefono = :telefono")})
public class ColaboradorEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String idColaborador;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    @OneToMany(mappedBy = "idColaborador")
    private List<BitacoraEntity> bitacoraEntityList;
    @OneToMany(mappedBy = "idColaborador")
    private List<ColaboradorCasoEntity> colaboradorCasoEntityList;

    public ColaboradorEntity() {
    }

    public ColaboradorEntity(String idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(String idColaborador) {
        this.idColaborador = idColaborador;
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

    @XmlTransient
    public List<BitacoraEntity> getBitacoraEntityList() {
        return bitacoraEntityList;
    }

    public void setBitacoraEntityList(List<BitacoraEntity> bitacoraEntityList) {
        this.bitacoraEntityList = bitacoraEntityList;
    }

    @XmlTransient
    public List<ColaboradorCasoEntity> getColaboradorCasoEntityList() {
        return colaboradorCasoEntityList;
    }

    public void setColaboradorCasoEntityList(List<ColaboradorCasoEntity> colaboradorCasoEntityList) {
        this.colaboradorCasoEntityList = colaboradorCasoEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColaborador != null ? idColaborador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColaboradorEntity)) {
            return false;
        }
        ColaboradorEntity other = (ColaboradorEntity) object;
        if ((this.idColaborador == null && other.idColaborador != null) || (this.idColaborador != null && !this.idColaborador.equals(other.idColaborador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.ColaboradorEntity[ idColaborador=" + idColaborador + " ]";
    }
    
}
