package dataholders;

import java.io.Serializable;

/**
 * Created by Punkid PC on 12/11/2016.
 */

public class ShowPaciente  implements Serializable{
    public String curp;
    public String nombre;
    public String apellidoP;
    public String apellidoM;

    public ShowPaciente(){

    }

    public ShowPaciente(String curp, String nombre, String apellidoP, String apellidoM) {
        this.curp = curp;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }




}
