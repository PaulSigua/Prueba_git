/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author UPS
 */
public class Vehiculo {
    
    private long id;
    private String placa;
    private int anio;

    public Vehiculo(long id, String placa, int anio) {
        this.id = id;
        this.placa = placa;
        this.anio = anio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", placa=" + placa + ", anio=" + anio + '}';
    }
    
    
}
