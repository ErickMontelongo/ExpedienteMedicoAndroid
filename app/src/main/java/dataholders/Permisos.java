package dataholders;

import java.io.Serializable;

/**
 * Created by Punkid PC on 23/11/2016.
 */

public class Permisos implements Serializable{

    private boolean historial;
    private boolean medicamentos;
    private boolean sintomas;
    private boolean estudios;

    public Permisos(boolean historial, boolean medicamentos, boolean sintomas, boolean estudios) {

        this.historial = historial;
        this.medicamentos = medicamentos;
        this.sintomas = sintomas;
        this.estudios = estudios;
    }

    public Permisos(){

    }

    public boolean isHistorial() {
        return historial;
    }

    public boolean isMedicamentos() {
        return medicamentos;
    }

    public boolean isSintomas() {
        return sintomas;
    }

    public boolean isEstudios() {
        return estudios;
    }

    public void setHistorial(boolean historial) {
        this.historial = historial;
    }

    public void setMedicamentos(boolean medicamentos) {
        this.medicamentos = medicamentos;
    }

    public void setSintomas(boolean sintomas) {
        this.sintomas = sintomas;
    }

    public void setEstudios(boolean estudios) {
        this.estudios = estudios;
    }

}
