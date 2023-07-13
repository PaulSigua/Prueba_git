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
public class Consume extends Thread {

    Bodega bodega;
    int valor = 200;
    
    Consume(Bodega bodega) {
        this.bodega = bodega;
    }

    @Override
    public void run() {
        while (true) {
            
            //System.out.println("Hilo consume " + getName());
            try {
                Thread.sleep(((int)(Math.random()*(6-1)))*valor);
                bodega.consumir(1);
                System.out.println("NUMEROOO: " + ((int)(Math.random()*(6-1)+1)));
            } catch (InterruptedException ex) {
                Logger.getLogger(Consume.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            //System.out.println(i + "--- " + getName());
        }
    }
    
    
}


//Productor: run(); 
//Consumidor: start();
//
