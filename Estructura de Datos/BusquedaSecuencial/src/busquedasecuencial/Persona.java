/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busquedasecuencial;

/**
 *
 * @author UPS
 */
public class Persona {
    private long id;
    private String nombre;
    private String cedula;

    public Persona(long id, String nombre, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", cedula=" + cedula + '}';
    }

}
