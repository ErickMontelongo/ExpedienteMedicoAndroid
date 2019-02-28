package dataholders;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Punkid PC on 26/01/2017.
 */

public class Cirugias implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idCirugias;
    private Date fecha;
    private String clinica;
    private String nombreOperacion;
    private Historiaclinica historiaClinicaidHistoriaClinica;
    private Collection<Resumencirugia> resumencirugiaCollection;

    public Cirugias() {
    }

    public Cirugias(Integer idCirugias) {
        this.idCirugias = idCirugias;
    }

    public Cirugias(Integer idCirugias, Date fecha, String clinica, String nombreOperacion) {
        this.idCirugias = idCirugias;
        this.fecha = fecha;
        this.clinica = clinica;
        this.nombreOperacion = nombreOperacion;
    }

    public Integer getIdCirugias() {
        return idCirugias;
    }

    public void setIdCirugias(Integer idCirugias) {
        this.idCirugias = idCirugias;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    public Historiaclinica getHistoriaClinicaidHistoriaClinica() {
        return historiaClinicaidHistoriaClinica;
    }

    public void setHistoriaClinicaidHistoriaClinica(Historiaclinica historiaClinicaidHistoriaClinica) {
        this.historiaClinicaidHistoriaClinica = historiaClinicaidHistoriaClinica;
    }

    public Collection<Resumencirugia> getResumencirugiaCollection() {
        return resumencirugiaCollection;
    }

    public void setResumencirugiaCollection(Collection<Resumencirugia> resumencirugiaCollection) {
        this.resumencirugiaCollection = resumencirugiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCirugias != null ? idCirugias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cirugias)) {
            return false;
        }
        Cirugias other = (Cirugias) object;
        if ((this.idCirugias == null && other.idCirugias != null) || (this.idCirugias != null && !this.idCirugias.equals(other.idCirugias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Cirugias[ idCirugias=" + idCirugias + " ]";
    }

}
