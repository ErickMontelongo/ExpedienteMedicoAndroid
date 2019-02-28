/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataholders;

import java.io.Serializable;



/**
 *
 * @author Punkid PC
 */
public class MedicoHasPaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    protected MedicoHasPacientePK medicoHasPacientePK;
    private boolean appSintomas;
    private boolean appEstudios;
    private boolean appMedicamentos;
    private boolean appHistorial;
    private Medico medico;
    private Paciente paciente;

    public MedicoHasPaciente() {
    }

    public MedicoHasPaciente(MedicoHasPacientePK medicoHasPacientePK) {
        this.medicoHasPacientePK = medicoHasPacientePK;
    }

    public MedicoHasPaciente(MedicoHasPacientePK medicoHasPacientePK, boolean appSintomas, boolean appEstudios, boolean appMedicamentos, boolean appHistorial) {
        this.medicoHasPacientePK = medicoHasPacientePK;
        this.appSintomas = appSintomas;
        this.appEstudios = appEstudios;
        this.appMedicamentos = appMedicamentos;
        this.appHistorial = appHistorial;
    }

    public MedicoHasPaciente(int medicoidMedico, String pacientecurp) {
        this.medicoHasPacientePK = new MedicoHasPacientePK(medicoidMedico, pacientecurp);
    }

    public MedicoHasPacientePK getMedicoHasPacientePK() {
        return medicoHasPacientePK;
    }

    public void setMedicoHasPacientePK(MedicoHasPacientePK medicoHasPacientePK) {
        this.medicoHasPacientePK = medicoHasPacientePK;
    }

    public boolean getAppSintomas() {
        return appSintomas;
    }

    public void setAppSintomas(boolean appSintomas) {
        this.appSintomas = appSintomas;
    }

    public boolean getAppEstudios() {
        return appEstudios;
    }

    public void setAppEstudios(boolean appEstudios) {
        this.appEstudios = appEstudios;
    }

    public boolean getAppMedicamentos() {
        return appMedicamentos;
    }

    public void setAppMedicamentos(boolean appMedicamentos) {
        this.appMedicamentos = appMedicamentos;
    }

    public boolean getAppHistorial() {
        return appHistorial;
    }

    public void setAppHistorial(boolean appHistorial) {
        this.appHistorial = appHistorial;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicoHasPacientePK != null ? medicoHasPacientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicoHasPaciente)) {
            return false;
        }
        MedicoHasPaciente other = (MedicoHasPaciente) object;
        if ((this.medicoHasPacientePK == null && other.medicoHasPacientePK != null) || (this.medicoHasPacientePK != null && !this.medicoHasPacientePK.equals(other.medicoHasPacientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.MedicoHasPaciente[ medicoHasPacientePK=" + medicoHasPacientePK + " ]";
    }
    
}
