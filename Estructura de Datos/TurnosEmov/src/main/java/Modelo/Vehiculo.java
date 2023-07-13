/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Adrian
 */
public class Vehiculo
{
    private String Palca;

    public Vehiculo(String Palca) {
        this.Palca = Palca;
    }

    public String getPalca() {
        return Palca;
    }

    public void setPalca(String Palca) {
        this.Palca = Palca;
    }

    @Override
    public String toString() {
        return "Vehiculos: " + "Placa=[" + Palca +']';
    }
    
    
}
