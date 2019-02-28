package dataholders;

import java.io.Serializable;

/**
 * Created by Punkid PC on 26/01/2017.
 */

public class Resumencirugia implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idResumenCirugia;
    private String ruta;
    private Cirugias cirugiasidCirugias;

    public Resumencirugia() {
    }

    public Resumencirugia(Integer idResumenCirugia) {
        this.idResumenCirugia = idResumenCirugia;
    }

    public Resumencirugia(Integer idResumenCirugia, String ruta) {
        this.idResumenCirugia = idResumenCirugia;
        this.ruta = ruta;
    }

    public Integer getIdResumenCirugia() {
        return idResumenCirugia;
    }

    public void setIdResumenCirugia(Integer idResumenCirugia) {
        this.idResumenCirugia = idResumenCirugia;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Cirugias getCirugiasidCirugias() {
        return cirugiasidCirugias;
    }

    public void setCirugiasidCirugias(Cirugias cirugiasidCirugias) {
        this.cirugiasidCirugias = cirugiasidCirugias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResumenCirugia != null ? idResumenCirugia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resumencirugia)) {
            return false;
        }
        Resumencirugia other = (Resumencirugia) object;
        if ((this.idResumenCirugia == null && other.idResumenCirugia != null) || (this.idResumenCirugia != null && !this.idResumenCirugia.equals(other.idResumenCirugia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Resumencirugia[ idResumenCirugia=" + idResumenCirugia + " ]";
    }

}
