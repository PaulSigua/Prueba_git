/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

/**
 *
 * @author LENOVO
 */
public class Bateria extends Observador{
    private int porcentaje;

    public Bateria(int porcentaje) {
        this.porcentaje = porcentaje;
        this.actualizar();
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public void actualizar() {
        getPorcentaje();
    }
    
}
