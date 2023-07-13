/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

/**
 *
 * @author LENOVO
 */
public class SolObservador extends Observador{

    private int porcentaje; 

    public SolObservador(Subject sujeto) {
        this.sujeto = sujeto;
        this.sujeto.agregar(this);
    }
    
    @Override
    public void actualizar() {
        //sujeto.setEstado(porcentaje);
    }

}
