/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sProdCons;

import ejemplohilos.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aplaza
 */
public class Consume extends Thread {

    Bodega bodega;
    Caja caja;
    int valor = 1000;
    
    Consume(Bodega bodega) {
        this.bodega = bodega;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            
            bodega.consumir(i);
            //System.out.println("Hilo consume " + getName());
            try {
                Thread.sleep(((int)(Math.random()*(6-1)))*valor);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consume.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            //System.out.println(i + "--- " + getName());
        }
        System.out.println("Termina thread " + getName());
    }
    
    
}


//Productor: run(); 
//Consumidor: start();
//
