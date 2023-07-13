/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.TimerTask;

/**
 *
 * @author LENOVO
 */
public class Tarea2TimerTask extends TimerTask {

    int seg = 0, min = 0;
    VistaBateria vista;
    
    public Tarea2TimerTask(VistaBateria vista){
        this.vista = vista;
    }
    @Override
    public void run() {
        
        seg++;
        if (seg == 60) {
            min++;
            seg = 0;
        }
        vista.actualizarTemporizador(min, seg);
    }

}
