/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataholders;

import java.io.Serializable;
import java.util.Collection;


/**
 *
 * @author Punkid PC
 */
 

public class Datosestudiosmedicos implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idDatosEstudiosMedicos;
    private String categoriaEstudio;
    private String nombreEstudio;
    private String nombreMedico;
    private String nombreClinica;
    private String interpretacion;
    private Collection<Estudiosmedicos> estudiosmedicosCollection;

    public Datosestudiosmedicos() {
    }

    public Datosestudiosmedicos(Integer idDatosEstudiosMedicos) {
        this.idDatosEstudiosMedicos = idDatosEstudiosMedicos;
    }

    public Datosestudiosmedicos(Integer idDatosEstudiosMedicos, String categoriaEstudio, String nombreEstudio, String nombreMedico, String nombreClinica, String interpretacion) {
        this.idDatosEstudiosMedicos = idDatosEstudiosMedicos;
        this.categoriaEstudio = categoriaEstudio;
        this.nombreEstudio = nombreEstudio;
        this.nombreMedico = nombreMedico;
        this.nombreClinica = nombreClinica;
        this.interpretacion = interpretacion;
    }

    public Integer getIdDatosEstudiosMedicos() {
        return idDatosEstudiosMedicos;
    }

    public void setIdDatosEstudiosMedicos(Integer idDatosEstudiosMedicos) {
        this.idDatosEstudiosMedicos = idDatosEstudiosMedicos;
    }

    public String getCategoriaEstudio() {
        return categoriaEstudio;
    }

    public void setCategoriaEstudio(String categoriaEstudio) {
        this.categoriaEstudio = categoriaEstudio;
    }

    public String getNombreEstudio() {
        return nombreEstudio;
    }

    public void setNombreEstudio(String nombreEstudio) {
        this.nombreEstudio = nombreEstudio;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getNombreClinica() {
        return nombreClinica;
    }

    public void setNombreClinica(String nombreClinica) {
        this.nombreClinica = nombreClinica;
    }

    public String getInterpretacion() {
        return interpretacion;
    }

    public void setInterpretacion(String interpretacion) {
        this.interpretacion = interpretacion;
    }

    public Collection<Estudiosmedicos> getEstudiosmedicosCollection() {
        return estudiosmedicosCollection;
    }

    public void setEstudiosmedicosCollection(Collection<Estudiosmedicos> estudiosmedicosCollection) {
        this.estudiosmedicosCollection = estudiosmedicosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDatosEstudiosMedicos != null ? idDatosEstudiosMedicos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datosestudiosmedicos)) {
            return false;
        }
        Datosestudiosmedicos other = (Datosestudiosmedicos) object;
        if ((this.idDatosEstudiosMedicos == null && other.idDatosEstudiosMedicos != null) || (this.idDatosEstudiosMedicos != null && !this.idDatosEstudiosMedicos.equals(other.idDatosEstudiosMedicos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Datosestudiosmedicos[ idDatosEstudiosMedicos=" + idDatosEstudiosMedicos + " ]";
    }
    
}
