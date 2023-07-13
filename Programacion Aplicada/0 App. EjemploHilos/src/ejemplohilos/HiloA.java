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
public class HiloA extends Thread
{            
    private Thread hiloB;
    
    HiloA(String nombre, Thread hilob)
    {
        super(nombre);
        this.hiloB = hilob;
    }
        
    @Override
    public void run()
    {
        try {
            hiloB.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloA.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*for (int i=0;i<10;i++)
        {
            try 
            {
                Thread.sleep(200); //Al mandarle un numero menor, el hilo B se ejecutara mas veces.
            //    System.out.println (getName());
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloA.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println (i+"--- "+getName());
        }
        System.out.println ("Termina thread "+getName());*/
        
    }
    
  // @Override
   /*public void run()
   {
       for(int i=0; i<10; i++)
       {
           try 
           {
               Thread.sleep(150);
           }
           catch (InterruptedException ex) 
           {
               Logger.getLogger(HiloA.class.getName()).log(Level.SEVERE, null, ex);
           }
           System.out.println (i+"--- "+getName());
       }
       System.out.println ("Termina thread "+getName());
   }*/
}
