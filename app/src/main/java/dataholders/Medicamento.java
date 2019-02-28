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
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idMedicamento;
    private Instruccionesingesta instruccionesIngestaidInstruccionesIngesta;
    private String nombreComercial;
    private String nombreGenerico;
    private String concentracion;
    private String viaAdministracion;
    private boolean alergia;
    private boolean activo;
    private String reaccionesAdversas;
    private String resultadoUso;
    private Prescripcion prescripcionidPrescripcion;

    public Medicamento() {
    }

    public Medicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Medicamento(Integer idMedicamento, String nombreComercial, String nombreGenerico, String concentracion, String viaAdministracion, boolean alergia, boolean activo, String reaccionesAdversas, String resultadoUso) {
        this.idMedicamento = idMedicamento;
        this.nombreComercial = nombreComercial;
        this.nombreGenerico = nombreGenerico;
        this.concentracion = concentracion;
        this.viaAdministracion = viaAdministracion;
        this.alergia = alergia;
        this.activo = activo;
        this.reaccionesAdversas = reaccionesAdversas;
        this.resultadoUso = resultadoUso;
    }

    public Integer getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNombreGenerico() {
        return nombreGenerico;
    }

    public void setNombreGenerico(String nombreGenerico) {
        this.nombreGenerico = nombreGenerico;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public String getViaAdministracion() {
        return viaAdministracion;
    }

    public void setViaAdministracion(String viaAdministracion) {
        this.viaAdministracion = viaAdministracion;
    }

    public boolean getAlergia() {
        return alergia;
    }

    public void setAlergia(boolean alergia) {
        this.alergia = alergia;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getReaccionesAdversas() {
        return reaccionesAdversas;
    }

    public void setReaccionesAdversas(String reaccionesAdversas) {
        this.reaccionesAdversas = reaccionesAdversas;
    }

    public String getResultadoUso() {
        return resultadoUso;
    }

    public void setResultadoUso(String resultadoUso) {
        this.resultadoUso = resultadoUso;
    }


    public Prescripcion getPrescripcionidPrescripcion() {
        return prescripcionidPrescripcion;
    }

    public void setPrescripcionidPrescripcion(Prescripcion prescripcionidPrescripcion) {
        this.prescripcionidPrescripcion = prescripcionidPrescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicamento != null ? idMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.idMedicamento == null && other.idMedicamento != null) || (this.idMedicamento != null && !this.idMedicamento.equals(other.idMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Medicamento[ idMedicamento=" + idMedicamento + " ]";
    }

    public Instruccionesingesta getInstruccionesIngestaidInstruccionesIngesta() {
        return instruccionesIngestaidInstruccionesIngesta;
    }

    public void setInstruccionesIngestaidInstruccionesIngesta(Instruccionesingesta instruccionesIngestaidInstruccionesIngesta) {
        this.instruccionesIngestaidInstruccionesIngesta = instruccionesIngestaidInstruccionesIngesta;
    }
    
}
