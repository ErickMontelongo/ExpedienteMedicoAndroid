package dataholders;

import java.io.Serializable;

/**
 * Created by Punkid PC on 26/01/2017.
 */

public class Archivosmedicos implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idArchivosMedicos;
    private String ruta;
    private Hospitalizacion hospitalizacionidHospitalizacion;

    public Archivosmedicos() {
    }

    public Archivosmedicos(Integer idArchivosMedicos) {
        this.idArchivosMedicos = idArchivosMedicos;
    }

    public Archivosmedicos(Integer idArchivosMedicos, String ruta) {
        this.idArchivosMedicos = idArchivosMedicos;
        this.ruta = ruta;
    }

    public Integer getIdArchivosMedicos() {
        return idArchivosMedicos;
    }

    public void setIdArchivosMedicos(Integer idArchivosMedicos) {
        this.idArchivosMedicos = idArchivosMedicos;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Hospitalizacion getHospitalizacionidHospitalizacion() {
        return hospitalizacionidHospitalizacion;
    }

    public void setHospitalizacionidHospitalizacion(Hospitalizacion hospitalizacionidHospitalizacion) {
        this.hospitalizacionidHospitalizacion = hospitalizacionidHospitalizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArchivosMedicos != null ? idArchivosMedicos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archivosmedicos)) {
            return false;
        }
        Archivosmedicos other = (Archivosmedicos) object;
        if ((this.idArchivosMedicos == null && other.idArchivosMedicos != null) || (this.idArchivosMedicos != null && !this.idArchivosMedicos.equals(other.idArchivosMedicos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Archivosmedicos[ idArchivosMedicos=" + idArchivosMedicos + " ]";
    }

}
