package dataholders;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Punkid PC on 26/01/2017.
 */

public class Informacionpersonal implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idInformacionPersonal;
    private String sexo;
    private Date fechaNac;
    private float altura;
    private float peso;
    private String tipoSangre;
    private boolean transfuciones;
    private Collection<Historiaclinica> historiaclinicaCollection;

    public Informacionpersonal() {
    }

    public Informacionpersonal(Integer idInformacionPersonal) {
        this.idInformacionPersonal = idInformacionPersonal;
    }

    public Informacionpersonal(Integer idInformacionPersonal, String sexo, Date fechaNac, float altura, float peso, String tipoSangre, boolean transfuciones) {
        this.idInformacionPersonal = idInformacionPersonal;
        this.sexo = sexo;
        this.fechaNac = fechaNac;
        this.altura = altura;
        this.peso = peso;
        this.tipoSangre = tipoSangre;
        this.transfuciones = transfuciones;
    }

    public Integer getIdInformacionPersonal() {
        return idInformacionPersonal;
    }

    public void setIdInformacionPersonal(Integer idInformacionPersonal) {
        this.idInformacionPersonal = idInformacionPersonal;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public boolean getTransfuciones() {
        return transfuciones;
    }

    public void setTransfuciones(boolean transfuciones) {
        this.transfuciones = transfuciones;
    }


    public Collection<Historiaclinica> getHistoriaclinicaCollection() {
        return historiaclinicaCollection;
    }

    public void setHistoriaclinicaCollection(Collection<Historiaclinica> historiaclinicaCollection) {
        this.historiaclinicaCollection = historiaclinicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInformacionPersonal != null ? idInformacionPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Informacionpersonal)) {
            return false;
        }
        Informacionpersonal other = (Informacionpersonal) object;
        if ((this.idInformacionPersonal == null && other.idInformacionPersonal != null) || (this.idInformacionPersonal != null && !this.idInformacionPersonal.equals(other.idInformacionPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Informacionpersonal[ idInformacionPersonal=" + idInformacionPersonal + " ]";
    }

}
