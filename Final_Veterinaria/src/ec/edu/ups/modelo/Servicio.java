/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.modelo;

/**
 *
 * @author guama
 */
public class Servicio {
    private int id;
    private double precio;
    private String nombre;
    private char iva,estado;

    public Servicio() {
    }

    public Servicio(int id, double precio, String nombre, char iva, char estado) {
        this.id = id;
        this.precio = precio;
        this.nombre = nombre;
        this.iva = iva;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public char getIva() {
        return iva;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIva(char iva) {
        this.iva = iva;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public char getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Servicio{" + "id=" + id + ", precio=" + precio + ", nombre=" + nombre + ", iva=" + iva + ", estado=" + estado + '}';
    }
    
    
    
}
