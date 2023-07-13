/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sProdCons;

import ejemplohilos.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.x509.IssuingDistributionPointExtension;

/**
 *
 * @author aplaza
 */
public class Produce extends Thread {

    Caja caja = new Caja();
    Bodega bodega;
    Produce(Bodega bodega) {
        this.bodega = bodega;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            caja.poner(i);
            System.out.println("Objetos generados " + (i+1));
            //System.out.println("Hilo produce " + getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Produce.class.getName()).log(Level.SEVERE, null, ex);
            }
            //System.out.println(i + "--- " + getName());
        }
        System.out.println("Termina thread " + getName());
    }
}
