package dataholders;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Punkid PC on 26/01/2017.
 */

public class Vacunas implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idVacunas;
    private String nombre;
    private Date fecha;
    private Historiaclinica historiaClinicaidHistoriaClinica;

    public Vacunas() {
    }

    public Vacunas(Integer idVacunas) {
        this.idVacunas = idVacunas;
    }

    public Vacunas(Integer idVacunas, String nombre, Date fecha) {
        this.idVacunas = idVacunas;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public Integer getIdVacunas() {
        return idVacunas;
    }

    public void setIdVacunas(Integer idVacunas) {
        this.idVacunas = idVacunas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        hash += (idVacunas != null ? idVacunas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacunas)) {
            return false;
        }
        Vacunas other = (Vacunas) object;
        if ((this.idVacunas == null && other.idVacunas != null) || (this.idVacunas != null && !this.idVacunas.equals(other.idVacunas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Vacunas[ idVacunas=" + idVacunas + " ]";
    }

}
