/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

/**
 *
 * @author LENOVO
 */
public class BateriaObservador extends Observador{

    private VistaBateria vista;
    public BateriaObservador(Subject sujeto, VistaBateria vista) {
        this.sujeto = sujeto;
        this.vista = vista;
        this.sujeto.agregar(this);
    }

    @Override
    public void actualizar() {
        vista.actualizarBateria(sujeto.getEstado());
    }
    
}
