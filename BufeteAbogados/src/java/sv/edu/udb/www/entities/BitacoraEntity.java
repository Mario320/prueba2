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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Kido
 */
@Entity
@Table(name = "bitacora")
@NamedQueries({
    @NamedQuery(name = "BitacoraEntity.findAll", query = "SELECT b FROM BitacoraEntity b")
    , @NamedQuery(name = "BitacoraEntity.findByIdBitacora", query = "SELECT b FROM BitacoraEntity b WHERE b.idBitacora = :idBitacora")
    , @NamedQuery(name = "BitacoraEntity.findByReferencia", query = "SELECT b FROM BitacoraEntity b WHERE b.referencia = :referencia")
    , @NamedQuery(name = "BitacoraEntity.findByIdColaborador", query = "SELECT b FROM BitacoraEntity b WHERE b.idColaborador = :idColaborador")
    , @NamedQuery(name = "BitacoraEntity.findByDetalle", query = "SELECT b FROM BitacoraEntity b WHERE b.detalle = :detalle")
    , @NamedQuery(name = "BitacoraEntity.findByFecha", query = "SELECT b FROM BitacoraEntity b WHERE b.fecha = :fecha")})
public class BitacoraEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String idBitacora;
    @Basic(optional = false)
    private String referencia;
    private String idColaborador;
    private String detalle;
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public BitacoraEntity() {
    }

    public BitacoraEntity(String idBitacora) {
        this.idBitacora = idBitacora;
    }

    public BitacoraEntity(String idBitacora, String referencia) {
        this.idBitacora = idBitacora;
        this.referencia = referencia;
    }

    public String getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(String idBitacora) {
        this.idBitacora = idBitacora;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(String idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBitacora != null ? idBitacora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitacoraEntity)) {
            return false;
        }
        BitacoraEntity other = (BitacoraEntity) object;
        if ((this.idBitacora == null && other.idBitacora != null) || (this.idBitacora != null && !this.idBitacora.equals(other.idBitacora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.BitacoraEntity[ idBitacora=" + idBitacora + " ]";
    }
    
}
