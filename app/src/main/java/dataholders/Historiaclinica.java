package dataholders;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Punkid PC on 26/01/2017.
 */

public class Historiaclinica implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idHistoriaClinica;
    private Collection<Toxicomanias> toxicomaniasCollection;
    private Collection<Cirugias> cirugiasCollection;
    private Collection<Paciente> pacienteCollection;
    private Collection<Antecedentes> antecedentesCollection;
    private Collection<Hospitalizacion> hospitalizacionCollection;
    private Collection<Enfermedades> enfermedadesCollection;
    private Collection<Vacunas> vacunasCollection;
    private Collection<Alergias> alergiasCollection;
    private Informacionpersonal informacionPersonalidInformacionPersonal;

    public Historiaclinica() {
    }

    public Historiaclinica(Integer idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    public Integer getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(Integer idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }


    public Collection<Toxicomanias> getToxicomaniasCollection() {
        return toxicomaniasCollection;
    }

    public void setToxicomaniasCollection(Collection<Toxicomanias> toxicomaniasCollection) {
        this.toxicomaniasCollection = toxicomaniasCollection;
    }


    public Collection<Cirugias> getCirugiasCollection() {
        return cirugiasCollection;
    }

    public void setCirugiasCollection(Collection<Cirugias> cirugiasCollection) {
        this.cirugiasCollection = cirugiasCollection;
    }


    public Collection<Paciente> getPacienteCollection() {
        return pacienteCollection;
    }

    public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
        this.pacienteCollection = pacienteCollection;
    }


    public Collection<Antecedentes> getAntecedentesCollection() {
        return antecedentesCollection;
    }

    public void setAntecedentesCollection(Collection<Antecedentes> antecedentesCollection) {
        this.antecedentesCollection = antecedentesCollection;
    }


    public Collection<Hospitalizacion> getHospitalizacionCollection() {
        return hospitalizacionCollection;
    }

    public void setHospitalizacionCollection(Collection<Hospitalizacion> hospitalizacionCollection) {
        this.hospitalizacionCollection = hospitalizacionCollection;
    }


    public Collection<Enfermedades> getEnfermedadesCollection() {
        return enfermedadesCollection;
    }

    public void setEnfermedadesCollection(Collection<Enfermedades> enfermedadesCollection) {
        this.enfermedadesCollection = enfermedadesCollection;
    }


    public Collection<Vacunas> getVacunasCollection() {
        return vacunasCollection;
    }

    public void setVacunasCollection(Collection<Vacunas> vacunasCollection) {
        this.vacunasCollection = vacunasCollection;
    }


    public Collection<Alergias> getAlergiasCollection() {
        return alergiasCollection;
    }

    public void setAlergiasCollection(Collection<Alergias> alergiasCollection) {
        this.alergiasCollection = alergiasCollection;
    }

    public Informacionpersonal getInformacionPersonalidInformacionPersonal() {
        return informacionPersonalidInformacionPersonal;
    }

    public void setInformacionPersonalidInformacionPersonal(Informacionpersonal informacionPersonalidInformacionPersonal) {
        this.informacionPersonalidInformacionPersonal = informacionPersonalidInformacionPersonal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistoriaClinica != null ? idHistoriaClinica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historiaclinica)) {
            return false;
        }
        Historiaclinica other = (Historiaclinica) object;
        if ((this.idHistoriaClinica == null && other.idHistoriaClinica != null) || (this.idHistoriaClinica != null && !this.idHistoriaClinica.equals(other.idHistoriaClinica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Historiaclinica[ idHistoriaClinica=" + idHistoriaClinica + " ]";
    }

}
