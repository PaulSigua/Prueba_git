/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

/**
 *
 * @author aplaza
 */
public class Empleado 
{
    private String nombre;
    private double hora;
    private double extras;

    public Empleado(String nombre) {
        this.nombre = nombre;
        this.hora = hora;
        this.extras = extras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getHora() {
        return hora;
    }

    public void setHora(double hora) {
        this.hora = hora;
    }

    public double getExtras() {
        return extras;
    }

    public void setExtras(double extras) {
        this.extras = extras;
    }
    
}
