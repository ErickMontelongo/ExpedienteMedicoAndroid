package dataholders;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Punkid PC on 26/01/2017.
 */

public class Hospitalizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idHospitalizacion;
    private Date fechaIngreso;
    private Date fechaSalida;
    private String clinica;
    private String causa;
    private Collection<Archivosmedicos> archivosmedicosCollection;
    private Historiaclinica historiaClinicaidHistoriaClinica;

    public Hospitalizacion() {
    }

    public Hospitalizacion(Integer idHospitalizacion) {
        this.idHospitalizacion = idHospitalizacion;
    }

    public Hospitalizacion(Integer idHospitalizacion, Date fechaIngreso, Date fechaSalida, String clinica, String causa) {
        this.idHospitalizacion = idHospitalizacion;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.clinica = clinica;
        this.causa = causa;
    }

    public Integer getIdHospitalizacion() {
        return idHospitalizacion;
    }

    public void setIdHospitalizacion(Integer idHospitalizacion) {
        this.idHospitalizacion = idHospitalizacion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }


    public Collection<Archivosmedicos> getArchivosmedicosCollection() {
        return archivosmedicosCollection;
    }

    public void setArchivosmedicosCollection(Collection<Archivosmedicos> archivosmedicosCollection) {
        this.archivosmedicosCollection = archivosmedicosCollection;
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
        hash += (idHospitalizacion != null ? idHospitalizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospitalizacion)) {
            return false;
        }
        Hospitalizacion other = (Hospitalizacion) object;
        if ((this.idHospitalizacion == null && other.idHospitalizacion != null) || (this.idHospitalizacion != null && !this.idHospitalizacion.equals(other.idHospitalizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Hospitalizacion[ idHospitalizacion=" + idHospitalizacion + " ]";
    }

}
