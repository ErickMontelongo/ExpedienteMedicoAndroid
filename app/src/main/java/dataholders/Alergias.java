package dataholders;

import java.io.Serializable;

/**
 * Created by Punkid PC on 26/01/2017.
 */

public class Alergias implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idAlergias;
    private String nombre;
    private Historiaclinica historiaClinicaidHistoriaClinica;

    public Alergias() {
    }

    public Alergias(Integer idAlergias) {
        this.idAlergias = idAlergias;
    }

    public Integer getIdAlergias() {
        return idAlergias;
    }

    public void setIdAlergias(Integer idAlergias) {
        this.idAlergias = idAlergias;
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
        hash += (idAlergias != null ? idAlergias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alergias)) {
            return false;
        }
        Alergias other = (Alergias) object;
        if ((this.idAlergias == null && other.idAlergias != null) || (this.idAlergias != null && !this.idAlergias.equals(other.idAlergias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Alergias[ idAlergias=" + idAlergias + " ]";
    }

}
