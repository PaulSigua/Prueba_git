/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursividad;

import controlador.ControladorRecursivo;

/**
 *
 * @author UPS
 */
public class Recursividad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControladorRecursivo controladorRecursivo = new ControladorRecursivo();
        long inicio = System.nanoTime();
        for (int i = 0; i < 40; i++) {
            controladorRecursivo.fibonassi(i);
        }
        System.out.println("Tiempo Recurisivo " +(System.nanoTime() - inicio)/1000);
        inicio = System.nanoTime();
        for (int i = 0; i < 40; i++) {
           controladorRecursivo.fibo(i);
        }
        System.out.println("Tiempo Iterativo: " +(System.nanoTime() - inicio)/1000);
        
    }
    
}
