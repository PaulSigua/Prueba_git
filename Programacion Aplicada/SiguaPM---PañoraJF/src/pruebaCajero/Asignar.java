/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaCajero;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Asignar extends Thread{
    Cajero cajero;
    private int tiempo;

    public Asignar(Cajero cajero, int tiempo) {
        this.cajero = cajero;
        this.tiempo = tiempo;
    }
    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(1000);
                cajero.asignar();
            } catch (InterruptedException ex) {
                Logger.getLogger(Asignar.class.getName()).log(Level.SEVERE, null, ex);
                Thread.currentThread().interrupt();
            }
        }
    }
}
