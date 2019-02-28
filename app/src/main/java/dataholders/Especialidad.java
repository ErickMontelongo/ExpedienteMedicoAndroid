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
public class Especialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idEspecialidad;
    private String nombre;
    @JsonIgnore
    private Collection<Medico> medicoCollection;

    public Especialidad() {
    }

    public Especialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Especialidad(Integer idEspecialidad, String nombre) {
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idEspecialidad != null ? idEspecialidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialidad)) {
            return false;
        }
        Especialidad other = (Especialidad) object;
        if ((this.idEspecialidad == null && other.idEspecialidad != null) || (this.idEspecialidad != null && !this.idEspecialidad.equals(other.idEspecialidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Especialidad[ idEspecialidad=" + idEspecialidad + " ]";
    }
    
}
