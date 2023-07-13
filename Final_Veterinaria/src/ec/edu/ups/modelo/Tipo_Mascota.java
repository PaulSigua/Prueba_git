/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.modelo;

/**
 *
 * @author guama
 */
public class Tipo_Mascota {
    private int id;
    private String nombre;

    public Tipo_Mascota() {
    }

    public Tipo_Mascota(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    @Override
    public String toString() {
        return "Tipo_Mascota{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
}
