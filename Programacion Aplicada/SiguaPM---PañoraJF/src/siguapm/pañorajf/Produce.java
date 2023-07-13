/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siguapm.pañorajf;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aplaza
 */
public class Produce extends Thread {

    Bodega bodega;
    int valor = 200;

    Produce(Bodega bodega) {
        this.bodega = bodega;
    }

    @Override
    public void run() {
        while (true) {

            //System.out.println("Hilo produce " + getName());
            try {
                Thread.sleep(((int) Math.random() * (6 - 1) + 1) * valor);
                bodega.producir(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Produce.class.getName()).log(Level.SEVERE, null, ex);
            }
            //System.out.println(i + "--- " + getName());
            //System.out.println(i + "--- " + getName());
        }
    }
}
