/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataholders;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Collection;



/**
 *
 * @author Punkid PC
 */
public class Direcciontrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idDireccionTrabajo;
    private String estado;
    private String municipio;
    private String calle;
    private String colonia;
    private String numeroTel;
    private String codigoPostal;
    private String nombreEmpresa;
    private String consultorio;
    @JsonIgnore
    private Collection<Medico> medicoCollection;

    public Direcciontrabajo() {
    }

    public Direcciontrabajo(Integer idDireccionTrabajo) {
        this.idDireccionTrabajo = idDireccionTrabajo;
    }

    public Direcciontrabajo(Integer idDireccionTrabajo, String estado, String municipio, String calle, String colonia, String numeroTel, String codigoPostal, String nombreEmpresa, String consultorio) {
        this.idDireccionTrabajo = idDireccionTrabajo;
        this.estado = estado;
        this.municipio = municipio;
        this.calle = calle;
        this.colonia = colonia;
        this.numeroTel = numeroTel;
        this.codigoPostal = codigoPostal;
        this.nombreEmpresa = nombreEmpresa;
        this.consultorio = consultorio;
    }

    public Integer getIdDireccionTrabajo() {
        return idDireccionTrabajo;
    }

    public void setIdDireccionTrabajo(Integer idDireccionTrabajo) {
        this.idDireccionTrabajo = idDireccionTrabajo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }


    public Collection<Medico> getMedicoCollection() {
        return medicoCollection;
    }

    public void setMedicoCollection(Collection<Medico> medicoCollection) {
        this.medicoCollection = medicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccionTrabajo != null ? idDireccionTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direcciontrabajo)) {
            return false;
        }
        Direcciontrabajo other = (Direcciontrabajo) object;
        if ((this.idDireccionTrabajo == null && other.idDireccionTrabajo != null) || (this.idDireccionTrabajo != null && !this.idDireccionTrabajo.equals(other.idDireccionTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Direcciontrabajo[ idDireccionTrabajo=" + idDireccionTrabajo + " ]";
    }
    
}
