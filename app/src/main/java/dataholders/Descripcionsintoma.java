/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataholders;

import java.io.Serializable;
import java.util.Collection;


/**
 *
 * @author Punkid PC
 */
public class Descripcionsintoma implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idDescripcionSintoma;
    private String intensidad;
    private String frecuencia;
    private String descripcion;
    private String regionCuerpo;
    private String regionEspecifica;
    private Collection<Sintoma> sintomaCollection;

    public Descripcionsintoma() {
    }

    public Descripcionsintoma(Integer idDescripcionSintoma) {
        this.idDescripcionSintoma = idDescripcionSintoma;
    }

    public Descripcionsintoma(Integer idDescripcionSintoma, String intensidad, String frecuencia, String descripcion, String regionCuerpo, String regionEspecifica) {
        this.idDescripcionSintoma = idDescripcionSintoma;
        this.intensidad = intensidad;
        this.frecuencia = frecuencia;
        this.descripcion = descripcion;
        this.regionCuerpo = regionCuerpo;
        this.regionEspecifica = regionEspecifica;
    }

    public Integer getIdDescripcionSintoma() {
        return idDescripcionSintoma;
    }

    public void setIdDescripcionSintoma(Integer idDescripcionSintoma) {
        this.idDescripcionSintoma = idDescripcionSintoma;
    }

    public String getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(String intensidad) {
        this.intensidad = intensidad;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRegionCuerpo() {
        return regionCuerpo;
    }

    public void setRegionCuerpo(String regionCuerpo) {
        this.regionCuerpo = regionCuerpo;
    }

    public String getRegionEspecifica() {
        return regionEspecifica;
    }

    public void setRegionEspecifica(String regionEspecifica) {
        this.regionEspecifica = regionEspecifica;
    }

    public Collection<Sintoma> getSintomaCollection() {
        return sintomaCollection;
    }

    public void setSintomaCollection(Collection<Sintoma> sintomaCollection) {
        this.sintomaCollection = sintomaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDescripcionSintoma != null ? idDescripcionSintoma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descripcionsintoma)) {
            return false;
        }
        Descripcionsintoma other = (Descripcionsintoma) object;
        if ((this.idDescripcionSintoma == null && other.idDescripcionSintoma != null) || (this.idDescripcionSintoma != null && !this.idDescripcionSintoma.equals(other.idDescripcionSintoma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Descripcionsintoma[ idDescripcionSintoma=" + idDescripcionSintoma + " ]";
    }
    
}
