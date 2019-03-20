/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author benja
 */
@Entity
@Table(name = "poder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PoderEntity.findAll", query = "SELECT p FROM PoderEntity p")
    , @NamedQuery(name = "PoderEntity.findByIdPoder", query = "SELECT p FROM PoderEntity p WHERE p.idPoder = :idPoder")
    , @NamedQuery(name = "PoderEntity.findByPoder", query = "SELECT p FROM PoderEntity p WHERE p.poder = :poder")
    , @NamedQuery(name = "PoderEntity.findByDetalle", query = "SELECT p FROM PoderEntity p WHERE p.detalle = :detalle")
    , @NamedQuery(name = "PoderEntity.findByOtorgante", query = "SELECT p FROM PoderEntity p WHERE p.otorgante = :otorgante")
    , @NamedQuery(name = "PoderEntity.findByFecha", query = "SELECT p FROM PoderEntity p WHERE p.fecha = :fecha")})
public class PoderEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String idPoder;
    private String poder;
    private String detalle;
    private String otorgante;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "IdCliente", referencedColumnName = "IdCliente")
    @ManyToOne(optional = false)
    private ClienteEntity idCliente;

    public PoderEntity() {
    }

    public PoderEntity(String idPoder) {
        this.idPoder = idPoder;
    }

    public String getIdPoder() {
        return idPoder;
    }

    public void setIdPoder(String idPoder) {
        this.idPoder = idPoder;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getOtorgante() {
        return otorgante;
    }

    public void setOtorgante(String otorgante) {
        this.otorgante = otorgante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ClienteEntity getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ClienteEntity idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPoder != null ? idPoder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoderEntity)) {
            return false;
        }
        PoderEntity other = (PoderEntity) object;
        if ((this.idPoder == null && other.idPoder != null) || (this.idPoder != null && !this.idPoder.equals(other.idPoder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.PoderEntity[ idPoder=" + idPoder + " ]";
    }
    
}
