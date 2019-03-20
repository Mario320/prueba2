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
@Table(name = "colaboradorcaso")
@NamedQueries({
    @NamedQuery(name = "ColaboradorCasoEntity.findAll", query = "SELECT c FROM ColaboradorCasoEntity c")
    , @NamedQuery(name = "ColaboradorCasoEntity.findByIdColaboradorCaso", query = "SELECT c FROM ColaboradorCasoEntity c WHERE c.idColaboradorCaso = :idColaboradorCaso")
    , @NamedQuery(name = "ColaboradorCasoEntity.findByIdColaborador", query = "SELECT c FROM ColaboradorCasoEntity c WHERE c.idColaborador = :idColaborador")
    , @NamedQuery(name = "ColaboradorCasoEntity.findByReferencia", query = "SELECT c FROM ColaboradorCasoEntity c WHERE c.referencia = :referencia")})
public class ColaboradorCasoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String idColaboradorCaso;
    private String idColaborador;
    private String referencia;

    public ColaboradorCasoEntity() {
    }

    public ColaboradorCasoEntity(String idColaboradorCaso) {
        this.idColaboradorCaso = idColaboradorCaso;
    }

    public String getIdColaboradorCaso() {
        return idColaboradorCaso;
    }

    public void setIdColaboradorCaso(String idColaboradorCaso) {
        this.idColaboradorCaso = idColaboradorCaso;
    }

    public String getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(String idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColaboradorCaso != null ? idColaboradorCaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColaboradorCasoEntity)) {
            return false;
        }
        ColaboradorCasoEntity other = (ColaboradorCasoEntity) object;
        if ((this.idColaboradorCaso == null && other.idColaboradorCaso != null) || (this.idColaboradorCaso != null && !this.idColaboradorCaso.equals(other.idColaboradorCaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.ColaboradorCasoEntity[ idColaboradorCaso=" + idColaboradorCaso + " ]";
    }
    
}
