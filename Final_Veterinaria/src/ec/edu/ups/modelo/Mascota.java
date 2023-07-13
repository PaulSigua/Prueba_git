/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.modelo;

/**
 *
 * @author guama
 */
public class Mascota {
    private int id,per_id,tipo_id;
    private String nombre;

    public Mascota() {
    }

    public Mascota(int id, int per_id, int tipo_id, String nombre) {
        this.id = id;
        this.per_id = per_id;
        this.tipo_id = tipo_id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public int getPer_id() {
        return per_id;
    }

    public int getTipo_id() {
        return tipo_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPer_id(int per_id) {
        this.per_id = per_id;
    }

    public void setTipo_id(int tipo_id) {
        this.tipo_id = tipo_id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    @Override
    public String toString() {
        return "Mascota{" + "id=" + id + ", per_id=" + per_id + ", tipo_id=" + tipo_id + ", nombre=" + nombre + '}';
    }
    
    
}

