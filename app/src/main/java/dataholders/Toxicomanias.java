package dataholders;

import java.io.Serializable;

/**
 * Created by Punkid PC on 26/01/2017.
 */

public class Toxicomanias implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idToxicomanias;
    private String nombre;
    private Historiaclinica historiaClinicaidHistoriaClinica;

    public Toxicomanias() {
    }

    public Toxicomanias(Integer idToxicomanias) {
        this.idToxicomanias = idToxicomanias;
    }

    public Toxicomanias(Integer idToxicomanias, String nombre) {
        this.idToxicomanias = idToxicomanias;
        this.nombre = nombre;
    }

    public Integer getIdToxicomanias() {
        return idToxicomanias;
    }

    public void setIdToxicomanias(Integer idToxicomanias) {
        this.idToxicomanias = idToxicomanias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idToxicomanias != null ? idToxicomanias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Toxicomanias)) {
            return false;
        }
        Toxicomanias other = (Toxicomanias) object;
        if ((this.idToxicomanias == null && other.idToxicomanias != null) || (this.idToxicomanias != null && !this.idToxicomanias.equals(other.idToxicomanias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Toxicomanias[ idToxicomanias=" + idToxicomanias + " ]";
    }

}
