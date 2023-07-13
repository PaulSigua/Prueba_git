/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplohilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aplaza
 */
public class HiloThread extends Thread {

    int tiempo;

    HiloThread(String nombre, int tiempo) {
        super(nombre);
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(i + "--- " + getName());
        }
        System.out.println("Termina thread " + getName());
    }
}
