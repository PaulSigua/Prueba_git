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
public class HiloB extends Thread
{
    private HiloA hiloA;
    HiloB(String nombre, HiloA hiloa)
    {
        super(nombre); //Hilo-1
        this.hiloA = hiloa;
    }
    
   @Override
   public void run()
   {
        try {
            hiloA.join();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*for(int i=0; i<10; i++)
            {
            try
            {
            Thread.sleep(200);
            //   System.out.println (getName());
            }
            catch (InterruptedException ex)
            {
            Logger.getLogger(HiloB.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println (i+"--- "+getName());
            }
            System.out.println ("Termina thread "+getName());*/
   }
}
