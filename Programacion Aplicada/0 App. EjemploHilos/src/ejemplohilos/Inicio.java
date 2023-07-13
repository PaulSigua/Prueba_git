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
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Thread hb;
        hb =new HiloB("Hilo B", ha);
        HiloA ha = new HiloA("Hilo A", hb);
        ha.start();
        hb.start();*/

        
        /*for(int i = 0; i < 10; i++){
            System.out.println("Hola mundo " + (i+1));
            
        }*/
        
        /*HiloThread h1 = new HiloThread("Hilo1", 300);
        HiloThread h2 = new HiloThread("Hilo2", 300);

        h1.start();
        try {
            h1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("actividad 1");
        h2.start();
        try {
            h2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("actividad 2");*/

        /*Thread t1=new Thread(new HiloRunnable(),"Hilo1");
        Thread t2=new Thread(new HiloRunnable(),"Hilo2");
        t1.start();
        t2.start();*/
        //LEER
        //HiloRunnable hr=new HiloRunnable();
        //hr.run();
    }

}
