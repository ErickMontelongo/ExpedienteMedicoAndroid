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
public class Direccionpaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idDireccionPaciente;
    private String estado;
    private String municipio;
    private String calle;
    private String colonia;
    private String numeroTel;
    private String codigoPostal;
    private Collection<Paciente> pacienteCollection;

    public Direccionpaciente() {
    }

    public Direccionpaciente(Integer idDireccionPaciente) {
        this.idDireccionPaciente = idDireccionPaciente;
    }

    public Direccionpaciente(Integer idDireccionPaciente, String estado, String municipio, String calle, String colonia, String numeroTel, String codigoPostal) {
        this.idDireccionPaciente = idDireccionPaciente;
        this.estado = estado;
        this.municipio = municipio;
        this.calle = calle;
        this.colonia = colonia;
        this.numeroTel = numeroTel;
        this.codigoPostal = codigoPostal;
    }

    public Integer getIdDireccionPaciente() {
        return idDireccionPaciente;
    }

    public void setIdDireccionPaciente(Integer idDireccionPaciente) {
        this.idDireccionPaciente = idDireccionPaciente;
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

    public Collection<Paciente> getPacienteCollection() {
        return pacienteCollection;
    }

    public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
        this.pacienteCollection = pacienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccionPaciente != null ? idDireccionPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccionpaciente)) {
            return false;
        }
        Direccionpaciente other = (Direccionpaciente) object;
        if ((this.idDireccionPaciente == null && other.idDireccionPaciente != null) || (this.idDireccionPaciente != null && !this.idDireccionPaciente.equals(other.idDireccionPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Direccionpaciente[ idDireccionPaciente=" + idDireccionPaciente + " ]";
    }
    
}
