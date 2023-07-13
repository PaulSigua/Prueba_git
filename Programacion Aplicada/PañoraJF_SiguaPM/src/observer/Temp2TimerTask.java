/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Temp2TimerTask extends TimerTask {

    int min = 0, seg = -1;
    VistaBateria vista;
    private Subject sujeto;

    public Temp2TimerTask(VistaBateria vista, Subject sujeto) {
        this.vista = vista;
        this.sujeto = sujeto;
    }

    @Override
    public void run() {
        if (sujeto.getEstado() != 100) {
            seg++;
            if (seg == 60) {
                min++;
                seg = 0;
            }
        }
        vista.actualizarTemporizador(min, seg);
    }

}
