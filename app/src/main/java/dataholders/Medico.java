/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataholders;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Collection;


/**
 *
 * @author Punkid PC
 */

public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idMedico;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String password;
    private Collection<MedicoHasPaciente> medicoHasPacienteCollection;
    private Direcciontrabajo direccionTrabajoidDireccionTrabajo;
    private Especialidad especialidadidEspecialidad;
    private Universidad universidadidUniversidad;

    public Medico() {
    }

    public Medico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Medico(Integer idMedico, String nombre, String apellidoP, String apellidoM, String password) {
        this.idMedico = idMedico;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.password = password;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<MedicoHasPaciente> getMedicoHasPacienteCollection() {
        return medicoHasPacienteCollection;
    }

    public void setMedicoHasPacienteCollection(Collection<MedicoHasPaciente> medicoHasPacienteCollection) {
        this.medicoHasPacienteCollection = medicoHasPacienteCollection;
    }

    public Direcciontrabajo getDireccionTrabajoidDireccionTrabajo() {
        return direccionTrabajoidDireccionTrabajo;
    }

    public void setDireccionTrabajoidDireccionTrabajo(Direcciontrabajo direccionTrabajoidDireccionTrabajo) {
        this.direccionTrabajoidDireccionTrabajo = direccionTrabajoidDireccionTrabajo;
    }

    public Especialidad getEspecialidadidEspecialidad() {
        return especialidadidEspecialidad;
    }

    public void setEspecialidadidEspecialidad(Especialidad especialidadidEspecialidad) {
        this.especialidadidEspecialidad = especialidadidEspecialidad;
    }

    public Universidad getUniversidadidUniversidad() {
        return universidadidUniversidad;
    }

    public void setUniversidadidUniversidad(Universidad universidadidUniversidad) {
        this.universidadidUniversidad = universidadidUniversidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedico != null ? idMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.idMedico == null && other.idMedico != null) || (this.idMedico != null && !this.idMedico.equals(other.idMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Medico[ idMedico=" + idMedico + " ]";
    }
    
}
