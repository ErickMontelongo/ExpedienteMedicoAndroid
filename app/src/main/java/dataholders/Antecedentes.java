package dataholders;

import java.io.Serializable;

/**
 * Created by Punkid PC on 26/01/2017.
 */

public class Antecedentes implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idAntecedentes;
    private String familiar;
    private boolean vivo;
    private String causa;
    private Historiaclinica historiaClinicaidHistoriaClinica;

    public Antecedentes() {
    }

    public Antecedentes(Integer idAntecedentes) {
        this.idAntecedentes = idAntecedentes;
    }

    public Antecedentes(Integer idAntecedentes, String familiar, boolean vivo) {
        this.idAntecedentes = idAntecedentes;
        this.familiar = familiar;
        this.vivo = vivo;
    }

    public Integer getIdAntecedentes() {
        return idAntecedentes;
    }

    public void setIdAntecedentes(Integer idAntecedentes) {
        this.idAntecedentes = idAntecedentes;
    }

    public String getFamiliar() {
        return familiar;
    }

    public void setFamiliar(String familiar) {
        this.familiar = familiar;
    }

    public boolean getVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
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
        hash += (idAntecedentes != null ? idAntecedentes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Antecedentes)) {
            return false;
        }
        Antecedentes other = (Antecedentes) object;
        if ((this.idAntecedentes == null && other.idAntecedentes != null) || (this.idAntecedentes != null && !this.idAntecedentes.equals(other.idAntecedentes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Antecedentes[ idAntecedentes=" + idAntecedentes + " ]";
    }

}
