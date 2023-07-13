/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sProdCons;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Bodega {
    
    private int valor = 0;
    boolean lleno = false;
    
    public synchronized void producir(int valor){
        if(lleno == true){ //Preunta si esta lleno
            
            try {
                System.out.println("Productor en espera");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Bodega.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        /////Tiene que producir//////
        this.valor = valor;
        this.lleno = true;
        System.out.println("Productor genera " + valor + " Lleno: " + lleno);
        notifyAll();
    }
    
    public synchronized void consumir(int valor){
        if(lleno == false){
            try {
                
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Bodega.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.valor = valor;
        this.lleno = false;
        System.out.println("Productor consume " + valor + " Lleno: " + lleno);
        notifyAll();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
