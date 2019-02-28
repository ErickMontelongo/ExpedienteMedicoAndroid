/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataholders;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Collection;



/**
 *
 * @author Punkid PC
 */
public class Universidad implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idUniversidad;
    private String nombre;
    private String clave;
    @JsonIgnore
    private Collection<Medico> medicoCollection;

    public Universidad() {
    }

    public Universidad(Integer idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    public Universidad(Integer idUniversidad, String nombre, String clave) {
        this.idUniversidad = idUniversidad;
        this.nombre = nombre;
        this.clave = clave;
    }

    public Integer getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(Integer idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Collection<Medico> getMedicoCollection() {
        return medicoCollection;
    }

    public void setMedicoCollection(Collection<Medico> medicoCollection) {
        this.medicoCollection = medicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUniversidad != null ? idUniversidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Universidad)) {
            return false;
        }
        Universidad other = (Universidad) object;
        if ((this.idUniversidad == null && other.idUniversidad != null) || (this.idUniversidad != null && !this.idUniversidad.equals(other.idUniversidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Universidad[ idUniversidad=" + idUniversidad + " ]";
    }
    
}
