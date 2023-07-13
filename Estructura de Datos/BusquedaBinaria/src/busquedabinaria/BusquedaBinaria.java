/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package busquedabinaria;

import java.util.Arrays;

/**
 *
 * @author UPS
 */
public class BusquedaBinaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Binaria binaria = new Binaria();
        int arreglo[] = {20,-8,-3,-1,0,1,6,7,9,10,13,15};
        Arrays.sort(arreglo);
        int posicion = Arrays.binarySearch(arreglo, 10);
        System.out.println("El elemento esta: " + posicion);
*/
        VistaPersona vistaPersona = new VistaPersona();
        vistaPersona.menu();
    }
    
}
