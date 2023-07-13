/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.modelo;

import java.util.Calendar;

/**
 *
 * @author guama
 */
public class Factura_Cabecera {
    private int id,per_id,usu_id;
    private Calendar fecha;
    private double subtotal,iva_total,total;
    private char estado;

    public Factura_Cabecera() {
    }

    public Factura_Cabecera(int id, int per_id, int usu_id, Calendar fecha, double subtotal, double iva_total, double total, char estado) {
        this.id = id;
        this.per_id = per_id;
        this.usu_id = usu_id;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.iva_total = iva_total;
        this.total = total;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public int getPer_id() {
        return per_id;
    }

    public int getUsu_id() {
        return usu_id;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getIva_total() {
        return iva_total;
    }

    public double getTotal() {
        return total;
    }

    public char getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPer_id(int per_id) {
        this.per_id = per_id;
    }

    public void setUsu_id(int usu_id) {
        this.usu_id = usu_id;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setIva_total(double iva_total) {
        this.iva_total = iva_total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
    

    @Override
    public String toString() {
        return "Factura_Cabecera{" + "id=" + id + ", per_id=" + per_id + ", usu_id=" + usu_id + ", fecha=" + fecha + ", subtotal=" + subtotal + ", iva_total=" + iva_total + ", total=" + total + ", estado=" + estado + '}';
    }
    
    
}
