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

public class MedicoHasPacientePK implements Serializable {

    private int medicoidMedico;
    private String pacientecurp;

    public MedicoHasPacientePK() {
    }

    public MedicoHasPacientePK(int medicoidMedico, String pacientecurp) {
        this.medicoidMedico = medicoidMedico;
        this.pacientecurp = pacientecurp;
    }

    public int getMedicoidMedico() {
        return medicoidMedico;
    }

    public void setMedicoidMedico(int medicoidMedico) {
        this.medicoidMedico = medicoidMedico;
    }

    public String getPacientecurp() {
        return pacientecurp;
    }

    public void setPacientecurp(String pacientecurp) {
        this.pacientecurp = pacientecurp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) medicoidMedico;
        hash += (pacientecurp != null ? pacientecurp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicoHasPacientePK)) {
            return false;
        }
        MedicoHasPacientePK other = (MedicoHasPacientePK) object;
        if (this.medicoidMedico != other.medicoidMedico) {
            return false;
        }
        if ((this.pacientecurp == null && other.pacientecurp != null) || (this.pacientecurp != null && !this.pacientecurp.equals(other.pacientecurp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.MedicoHasPacientePK[ medicoidMedico=" + medicoidMedico + ", pacientecurp=" + pacientecurp + " ]";
    }
    
}
