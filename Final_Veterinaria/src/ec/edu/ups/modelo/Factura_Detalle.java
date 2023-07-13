/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.modelo;

/**
 *
 * @author guama
 */
public class Factura_Detalle {
    private int id,cantidad,ser_id,fac_id;
    private double precio_unitario,subtotal,valor_iva,total;

    public Factura_Detalle() {
    }

    public Factura_Detalle(int id, int cantidad, int ser_id, int fac_id, double precio_unitario, double subtotal, double valor_iva, double total) {
        this.id = id;
        this.cantidad = cantidad;
        this.ser_id = ser_id;
        this.fac_id = fac_id;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;
        this.valor_iva = valor_iva;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getSer_id() {
        return ser_id;
    }

    public int getFac_id() {
        return fac_id;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getValor_iva() {
        return valor_iva;
    }

    public double getTotal() {
        return total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setSer_id(int ser_id) {
        this.ser_id = ser_id;
    }

    public void setFac_id(int fac_id) {
        this.fac_id = fac_id;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setValor_iva(double valor_iva) {
        this.valor_iva = valor_iva;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    

    @Override
    public String toString() {
        return "Factura_Detalle{" + "id=" + id + ", cantidad=" + cantidad + ", ser_id=" + ser_id + ", fac_id=" + fac_id + ", precio_unitario=" + precio_unitario + ", subtotal=" + subtotal + ", valor_iva=" + valor_iva + ", total=" + total + '}';
    }
    
    
}
