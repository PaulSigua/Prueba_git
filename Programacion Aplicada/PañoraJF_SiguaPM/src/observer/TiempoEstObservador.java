/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

/**
 *
 * @author LENOVO
 */
public class TiempoEstObservador extends Observador{

    VistaBateria vista;
    public TiempoEstObservador(Subject sujeto, VistaBateria vista) {
        this.sujeto = sujeto;
        this.vista = vista;
        this.sujeto.agregar(this);
    }

    @Override
    public void actualizar() {
        vista.actualizarTiempoEstimado(Math.round((100.0 - (double)sujeto.getEstado())/ 2.0));
    }
    
}
