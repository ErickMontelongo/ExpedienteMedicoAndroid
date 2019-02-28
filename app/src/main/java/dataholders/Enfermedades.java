package dataholders;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Punkid PC on 26/01/2017.
 */

public class Enfermedades implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idEnfermedades;
    private String nombre;
    private Date fechaDiagnostico;
    private String tratamiento;
    private Historiaclinica historiaClinicaidHistoriaClinica;

    public Enfermedades() {
    }

    public Enfermedades(Integer idEnfermedades) {
        this.idEnfermedades = idEnfermedades;
    }

    public Enfermedades(Integer idEnfermedades, String nombre, Date fechaDiagnostico, String tratamiento) {
        this.idEnfermedades = idEnfermedades;
        this.nombre = nombre;
        this.fechaDiagnostico = fechaDiagnostico;
        this.tratamiento = tratamiento;
    }

    public Integer getIdEnfermedades() {
        return idEnfermedades;
    }

    public void setIdEnfermedades(Integer idEnfermedades) {
        this.idEnfermedades = idEnfermedades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(Date fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Historiaclinica getHistoriaClinicaidHistoriaClinica() {
        return historiaClinicaidHistoriaClinica;
    }

    public void setHistoriaClinicaidHistoriaClinica(Historiaclinica historiaClinicaidHistoriaClinica) {
        this.historiaClinicaidHistoriaClinica = historiaClinicaidHistoriaClinica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnfermedades != null ? idEnfermedades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enfermedades)) {
            return false;
        }
        Enfermedades other = (Enfermedades) object;
        if ((this.idEnfermedades == null && other.idEnfermedades != null) || (this.idEnfermedades != null && !this.idEnfermedades.equals(other.idEnfermedades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Enfermedades[ idEnfermedades=" + idEnfermedades + " ]";
    }

}
