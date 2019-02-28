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
public class Instruccionesingesta implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idInstruccionesIngesta;
    private String duracion;
    private String frecuencia;
    private String lunes;
    private String martes;
    private String miercoles;
    private String jueves;
    private String viernes;
    private String sabado;
    private String domingo;
    private Collection<Medicamento> medicamentoCollection;

    public Instruccionesingesta() {
    }

    public Instruccionesingesta(Integer idInstruccionesIngesta) {
        this.idInstruccionesIngesta = idInstruccionesIngesta;
    }

    public Instruccionesingesta(Integer idInstruccionesIngesta, String duracion, String frecuencia, String lunes, String martes, String miercoles, String jueves, String viernes, String sabado, String domingo) {
        this.idInstruccionesIngesta = idInstruccionesIngesta;
        this.duracion = duracion;
        this.frecuencia = frecuencia;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.domingo = domingo;
    }

    public Integer getIdInstruccionesIngesta() {
        return idInstruccionesIngesta;
    }

    public void setIdInstruccionesIngesta(Integer idInstruccionesIngesta) {
        this.idInstruccionesIngesta = idInstruccionesIngesta;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getLunes() {
        return lunes;
    }

    public void setLunes(String lunes) {
        this.lunes = lunes;
    }

    public String getMartes() {
        return martes;
    }

    public void setMartes(String martes) {
        this.martes = martes;
    }

    public String getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(String miercoles) {
        this.miercoles = miercoles;
    }

    public String getJueves() {
        return jueves;
    }

    public void setJueves(String jueves) {
        this.jueves = jueves;
    }

    public String getViernes() {
        return viernes;
    }

    public void setViernes(String viernes) {
        this.viernes = viernes;
    }

    public String getSabado() {
        return sabado;
    }

    public void setSabado(String sabado) {
        this.sabado = sabado;
    }

    public String getDomingo() {
        return domingo;
    }

    public void setDomingo(String domingo) {
        this.domingo = domingo;
    }

    public Collection<Medicamento> getMedicamentoCollection() {
        return medicamentoCollection;
    }

    public void setMedicamentoCollection(Collection<Medicamento> medicamentoCollection) {
        this.medicamentoCollection = medicamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstruccionesIngesta != null ? idInstruccionesIngesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instruccionesingesta)) {
            return false;
        }
        Instruccionesingesta other = (Instruccionesingesta) object;
        if ((this.idInstruccionesIngesta == null && other.idInstruccionesIngesta != null) || (this.idInstruccionesIngesta != null && !this.idInstruccionesIngesta.equals(other.idInstruccionesIngesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Instruccionesingesta[ idInstruccionesIngesta=" + idInstruccionesIngesta + " ]";
    }
    
}
