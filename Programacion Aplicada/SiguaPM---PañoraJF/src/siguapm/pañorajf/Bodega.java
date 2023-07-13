/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package siguapm.pañorajf;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Bodega {

    private int cantidad;
    //boolean lleno = false;

    public synchronized void producir(int valor) throws InterruptedException {
        if (cantidad >= 4) { 

            System.out.println("-----------------------------");
            System.out.println("Productor en espera");
            wait();
        } else {
            cantidad = cantidad + valor;
            System.out.println("Productor genera: " + cantidad + " Bodega: " + cantidad);
            notifyAll();
        }

    }

    public synchronized void consumir(int valor) throws InterruptedException {
        if (cantidad == 0) {
            System.out.println("Consumidor en espera");
            wait();
        }
        int cantidad2 = cantidad;
        cantidad = cantidad - valor;
        System.out.println("Consumidor consume " + cantidad2 + " Bodega: " + cantidad);
            notifyAll();
    }
}
