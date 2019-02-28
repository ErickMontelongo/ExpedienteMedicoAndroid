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
public class Sintoma implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idSintoma;
    private Date fechaInicio;
    private Date fechaFin;
    private Date dateInicio;
    private Date dateFin;
    private String nombre;
    private Descripcionsintoma descripcionSintomaidDescripcionSintoma;
    private Paciente pacientecurp;

    public Sintoma() {
    }

    public Sintoma(Integer idSintoma) {
        this.idSintoma = idSintoma;
    }

    public Sintoma(Integer idSintoma, Date fechaInicio, Date fechaFin, Date dateInicio, Date dateFin, String nombre) {
        this.idSintoma = idSintoma;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.dateInicio = dateInicio;
        this.dateFin = dateFin;
        this.nombre = nombre;
    }

    public Integer getIdSintoma() {
        return idSintoma;
    }

    public void setIdSintoma(Integer idSintoma) {
        this.idSintoma = idSintoma;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getDateInicio() {
        return dateInicio;
    }

    public void setDateInicio(Date dateInicio) {
        this.dateInicio = dateInicio;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Descripcionsintoma getDescripcionSintomaidDescripcionSintoma() {
        return descripcionSintomaidDescripcionSintoma;
    }

    public void setDescripcionSintomaidDescripcionSintoma(Descripcionsintoma descripcionSintomaidDescripcionSintoma) {
        this.descripcionSintomaidDescripcionSintoma = descripcionSintomaidDescripcionSintoma;
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
        hash += (idSintoma != null ? idSintoma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sintoma)) {
            return false;
        }
        Sintoma other = (Sintoma) object;
        if ((this.idSintoma == null && other.idSintoma != null) || (this.idSintoma != null && !this.idSintoma.equals(other.idSintoma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Sintoma[ idSintoma=" + idSintoma + " ]";
    }
    
}
