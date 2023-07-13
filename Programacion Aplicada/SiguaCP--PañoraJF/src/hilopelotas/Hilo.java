/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilopelotas;

import java.awt.Color;

/**
 *
 * @author LENOVO
 */
public class Hilo extends Thread {

    Pelota pelota;
    Lienzo lienzo;
    int tiempo;

    public Hilo(Pelota pelota, Lienzo lienzo, int tiempo, Color color) {
        this.pelota = pelota;
        this.lienzo = lienzo;
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        //Pelota pelota1=new Pelota();	SI YO HAGO LA INSTANCIA DENTRO DEL METODO RUN, SE BORRAN LAS ACCIONES 	
        //lienzo.add(pelota1);          CADA VEZ QUE USEMOS EL METODO OTRA VEZ

        System.out.println(Thread.currentThread().isInterrupted());
        while (!Thread.currentThread().isInterrupted()) {
            pelota.mueve_pelota();
            //lienzo.paint(lienzo.getGraphics());	
            lienzo.repaint();
            try {
                Thread.sleep(tiempo);

            } catch (InterruptedException ex) {

                Thread.currentThread().interrupt();
                //Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(Thread.currentThread().isInterrupted());
    }

}
