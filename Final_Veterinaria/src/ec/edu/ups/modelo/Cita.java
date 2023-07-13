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
public class Cita {
    private int id,mas_id,per_id;
    private Calendar fecha;
    private char estado;

    public Cita() {
    }

    public Cita(int id, int mas_id, int per_id, Calendar fecha, char estado) {
        this.id = id;
        this.mas_id = mas_id;
        this.per_id = per_id;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public int getMas_id() {
        return mas_id;
    }

    public int getPer_id() {
        return per_id;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public char getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMas_id(int mas_id) {
        this.mas_id = mas_id;
    }

    public void setPer_id(int per_id) {
        this.per_id = per_id;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
    

    @Override
    public String toString() {
        return "Citas{" + "id=" + id + ", mas_id=" + mas_id + ", per_id=" + per_id + ", fecha=" + fecha + ", estado=" + estado + '}';
    }
    
    
    
}
