/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busquedabinaria;

/**
 *
 * @author UPS
 */
public class Persona {
    private long id;
    private String cedula;

    public Persona(long id, String cedula) {
        this.id = id;
        this.cedula = cedula;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", cedula=" + cedula + '}';
    }
    
    
}
