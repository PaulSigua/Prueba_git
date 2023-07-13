
package controllers;

import conexion.*;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public class Tables {
    Conexion con;
    private String sentencia;
    private int id;

    public Tables() {
        con = new Conexion();
        this.sentencia = "";
        this.id = 0;
    }
    
    public ArrayList table(){
        ArrayList<String> list = new ArrayList<>();
        list.add(sentencia);
        for(id = 0; id < list.size(); id++){
            System.out.println("El id de la tabla es: " + id);
        }
        
        return list;
    }
    
}
