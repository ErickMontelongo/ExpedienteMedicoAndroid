/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataholders;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author Punkid PC
 */
public class Estudiosmedicos implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idEstudiosMedicos;
    private String rutaImagen;
    private String rutaCarpetaImagenes;
    private Date fechaEstudio;
    private Datosestudiosmedicos datosEstudiosMedicosidDatosEstudiosMedicos;
    private Paciente pacientecurp;

    public Estudiosmedicos() {
    }

    public Estudiosmedicos(Integer idEstudiosMedicos) {
        this.idEstudiosMedicos = idEstudiosMedicos;
    }

    public Estudiosmedicos(Integer idEstudiosMedicos, String rutaImagen, String rutaCarpetaImagenes, Date fechaEstudio) {
        this.idEstudiosMedicos = idEstudiosMedicos;
        this.rutaImagen = rutaImagen;
        this.rutaCarpetaImagenes = rutaCarpetaImagenes;
        this.fechaEstudio = fechaEstudio;
    }

    public Integer getIdEstudiosMedicos() {
        return idEstudiosMedicos;
    }

    public void setIdEstudiosMedicos(Integer idEstudiosMedicos) {
        this.idEstudiosMedicos = idEstudiosMedicos;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getRutaCarpetaImagenes() {
        return rutaCarpetaImagenes;
    }

    public void setRutaCarpetaImagenes(String rutaCarpetaImagenes) {
        this.rutaCarpetaImagenes = rutaCarpetaImagenes;
    }

    public Date getFechaEstudio() {
        return fechaEstudio;
    }

    public void setFechaEstudio(Date fechaEstudio) {
        this.fechaEstudio = fechaEstudio;
    }

    public Datosestudiosmedicos getDatosEstudiosMedicosidDatosEstudiosMedicos() {
        return datosEstudiosMedicosidDatosEstudiosMedicos;
    }

    public void setDatosEstudiosMedicosidDatosEstudiosMedicos(Datosestudiosmedicos datosEstudiosMedicosidDatosEstudiosMedicos) {
        this.datosEstudiosMedicosidDatosEstudiosMedicos = datosEstudiosMedicosidDatosEstudiosMedicos;
    }

    public Paciente getPacientecurp() {
        return pacientecurp;
    }

    public void setPacientecurp(Paciente pacientecurp) {
        this.pacientecurp = pacientecurp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudiosMedicos != null ? idEstudiosMedicos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiosmedicos)) {
            return false;
        }
        Estudiosmedicos other = (Estudiosmedicos) object;
        if ((this.idEstudiosMedicos == null && other.idEstudiosMedicos != null) || (this.idEstudiosMedicos != null && !this.idEstudiosMedicos.equals(other.idEstudiosMedicos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Estudiosmedicos[ idEstudiosMedicos=" + idEstudiosMedicos + " ]";
    }
    
}
