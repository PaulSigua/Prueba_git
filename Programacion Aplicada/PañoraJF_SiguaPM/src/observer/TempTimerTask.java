/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class TempTimerTask extends TimerTask {

    int seg = 0, min = 0;
    private Subject sujeto;
    int bateria;
    VistaBateria vista;

    public TempTimerTask(Subject sujeto, int bateria, VistaBateria vista) {
        this.sujeto = sujeto;
        this.bateria = bateria;
        this.vista = vista;
    }

    @Override
    public void run() {
        if (bateria < 100) {
            bateria++;
            vista.setBateria(bateria);
            sujeto.setEstado(bateria);
            System.out.println("Estado:"+sujeto.getEstado());
        }
        if (bateria == 100) {
            this.cancel();
            JOptionPane.showMessageDialog(null, "La bateria esta cargada");
        }
    }
}
