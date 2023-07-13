/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilointerrumpir;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aplaza
 */
public class Hilo extends Thread
{
    private Pelota pelota;
    private Component lienzo;
    int tiempo;
    
    public Hilo(Pelota pelota, Component componente, int tiempo)
    {
        this.pelota=pelota;
        lienzo=componente;
        this.tiempo=tiempo;
    }
    
    public void run()
    {
        
        //for (int i=1; i<=80; i++)
        //while(!Thread.interrupted())
        System.out.println (Thread.currentThread().isInterrupted());
        while(!Thread.currentThread().isInterrupted())
        {
            pelota.mueve_pelota();
            //pelota.mueve_pelota(lienzo.getBounds());			
            lienzo.repaint();	
            
            try 
            {
                Thread.sleep(tiempo);
            } 
            catch (InterruptedException ex) 
            {
               // Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                Thread.currentThread().interrupt();
            }
	}
        System.out.println (Thread.currentThread().isInterrupted());
    }
}
