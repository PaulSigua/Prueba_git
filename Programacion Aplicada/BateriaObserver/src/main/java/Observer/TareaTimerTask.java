/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import java.util.TimerTask;
/**
 *
 * @author LENOVO
 */
public class TareaTimerTask extends TimerTask{

    int seg = 0, min = 0;
    VistaBateria vista;
    public Observador observador;
    public Subject sujeto;
    
    public TareaTimerTask(VistaBateria vista, Subject sujeto){
        this.vista = vista;
        this.sujeto = sujeto;
        this.sujeto.agregar(observador);
    }
    @Override
    public void run() {
        
        seg++;
        if (seg == 60) {
            min++;
            seg = 0;
        }if(min == 2){
            
        }
        vista.actualizarTemporizador(min, seg);
    }
    public void actualizarTimer(){
        observador.actualizar();
    }

}
