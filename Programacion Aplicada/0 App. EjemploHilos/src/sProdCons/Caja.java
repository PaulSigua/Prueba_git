/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sProdCons;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Caja {

    private int valor;
    private boolean lleno = false;

    public synchronized void poner(int valor) {
        if (lleno == true) {

            System.out.println("Productor: buffer lleno " + valor + " ");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.valor = valor*4;
        this.lleno = true;
        System.out.println("Productor pone " + valor + " Lleno: " + lleno);
        notifyAll();
    }

    public synchronized void sacar(int valor) {
        if (lleno == false) {
            System.out.println("Productor: buffer lleno" + valor + " ");

            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        this.valor = valor;
        this.lleno = false;
        System.out.println("Productor saca " + valor + " Lleno: " + lleno);
        notifyAll();
    }

}
