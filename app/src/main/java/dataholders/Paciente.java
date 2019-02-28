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
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    private String curp;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String password;
    private Collection<MedicoHasPaciente> medicoHasPacienteCollection;
    private Collection<Prescripcion> prescripcionCollection;
    private Collection<Estudiosmedicos> estudiosmedicosCollection;
    private Direccionpaciente direccionPacienteidDireccionPaciente;
    private Collection<Sintoma> sintomaCollection;
    private Historiaclinica historiaClinicaidHistoriaClinica;

    public Paciente() {
    }

    public Paciente(String curp) {
        this.curp = curp;
    }

    public Paciente(String curp, String nombre, String apellidoP, String apellidoM, String password) {
        this.curp = curp;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.password = password;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
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


    public Collection<Prescripcion> getPrescripcionCollection() {
        return prescripcionCollection;
    }

    public void setPrescripcionCollection(Collection<Prescripcion> prescripcionCollection) {
        this.prescripcionCollection = prescripcionCollection;
    }


    public Collection<Estudiosmedicos> getEstudiosmedicosCollection() {
        return estudiosmedicosCollection;
    }

    public void setEstudiosmedicosCollection(Collection<Estudiosmedicos> estudiosmedicosCollection) {
        this.estudiosmedicosCollection = estudiosmedicosCollection;
    }

    public Direccionpaciente getDireccionPacienteidDireccionPaciente() {
        return direccionPacienteidDireccionPaciente;
    }

    public void setDireccionPacienteidDireccionPaciente(Direccionpaciente direccionPacienteidDireccionPaciente) {
        this.direccionPacienteidDireccionPaciente = direccionPacienteidDireccionPaciente;
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
        hash += (curp != null ? curp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.curp == null && other.curp != null) || (this.curp != null && !this.curp.equals(other.curp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Paciente[ curp=" + curp + " ]";
    }

    public Historiaclinica getHistoriaClinicaidHistoriaClinica() {
        return historiaClinicaidHistoriaClinica;
    }

    public void setHistoriaClinicaidHistoriaClinica(Historiaclinica historiaClinicaidHistoriaClinica) {
        this.historiaClinicaidHistoriaClinica = historiaClinicaidHistoriaClinica;
    }
    
}
