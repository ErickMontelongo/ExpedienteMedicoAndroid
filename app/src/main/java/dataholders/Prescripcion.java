/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataholders;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


/**
 *
 * @author Punkid PC
 */
public class Prescripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idPrescripcion;
    private Date fecha;
    private String medico;
    private int cedula;
    private Paciente pacientecurp;
    private Collection<Medicamento> medicamentoCollection;

    public Prescripcion() {
    }

    public Prescripcion(Integer idPrescripcion) {
        this.idPrescripcion = idPrescripcion;
    }

    public Prescripcion(Integer idPrescripcion, Date fecha, String medico, int cedula) {
        this.idPrescripcion = idPrescripcion;
        this.fecha = fecha;
        this.medico = medico;
        this.cedula = cedula;
    }

    public Integer getIdPrescripcion() {
        return idPrescripcion;
    }

    public void setIdPrescripcion(Integer idPrescripcion) {
        this.idPrescripcion = idPrescripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public Paciente getPacientecurp() {
        return pacientecurp;
    }

    public void setPacientecurp(Paciente pacientecurp) {
        this.pacientecurp = pacientecurp;
    }


    public Collection<Medicamento> getMedicamentoCollection() {
        return medicamentoCollection;
    }

    public void setMedicamentoCollection(Collection<Medicamento> medicamentoCollection) {
        this.medicamentoCollection = medicamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrescripcion != null ? idPrescripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prescripcion)) {
            return false;
        }
        Prescripcion other = (Prescripcion) object;
        if ((this.idPrescripcion == null && other.idPrescripcion != null) || (this.idPrescripcion != null && !this.idPrescripcion.equals(other.idPrescripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Prescripcion[ idPrescripcion=" + idPrescripcion + " ]";
    }
    
}
