/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author UPS
 */
public class Jugador {
    
    private long id;
    private int numero;
    private String nombre;
    private String posicion;

    public Jugador(long id, int numero, String nombre, String posicion) {
        this.id = id;
        this.numero = numero;
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", numero=" + numero + ", nombre=" + nombre + ", posicion=" + posicion + '}';
    }
    
    
}
