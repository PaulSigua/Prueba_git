/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.modelo;

/**
 *
 * @author guama
 */
public class Det_Fac_Servicio {
    private int id;
    private String nombre;
    private double iva;
    private double Precio;
    private int cantidad;
    private double subtotal;
    private double total;

    public Det_Fac_Servicio() {
    }

    public Det_Fac_Servicio(int id, String nombre,double iva, double Precio, int cantidad,double subtotal, double total) {
        this.id = id;
        this.nombre = nombre;
        this.iva=iva;
        this.Precio = Precio;
        this.cantidad = cantidad;
        this.subtotal=subtotal;
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    
    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Det_Fac_Servicio{" + "id=" + id + ", nombre=" + nombre + ", Precio=" + Precio + ", cantidad=" + cantidad + ", total=" + total + '}';
    }
    
    
}
