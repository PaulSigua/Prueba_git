/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Alienware
 */
public class Persona {
    private String nombre;
    private String direccion;
    private String id;

    public Persona(String Nombre, String Direccion, String id) {
        this.nombre = Nombre;
        this.direccion = Direccion;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getId() {
        return id;
    }
    
    public int getNCampos(){
        return 3;
    }
    
    @Override
    public String toString(){
        return nombre + ", " + direccion + ", " + id;
    }
}
