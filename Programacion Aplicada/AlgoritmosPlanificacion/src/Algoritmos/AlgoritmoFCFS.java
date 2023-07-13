
package Algoritmos;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author LENOVO
 */
public class AlgoritmoFCFS {

    private Vector referencias;
    private ArrayList desplazamientos;
    private int totalDesplazameintos;

    public AlgoritmoFCFS(Vector referencias) {
        this.referencias = referencias;
        desplazamientos = new ArrayList();
        totalDesplazameintos = 0;
    }

    public void operar() {
        System.out.println("LOGARITMO FCFS");
        System.out.println("Referencias: "+referencias);
        for (int i = 0; i < referencias.size() - 1; i++) {
            int posA = Integer.parseInt(referencias.get(i) + "");
            int posB = Integer.parseInt(referencias.get(i + 1) + "");
            int result = Math.abs(posA - posB);
            desplazamientos.add(result);
        }
        for (int j = 0; j < desplazamientos.size(); j++) {
            int numA = Integer.parseInt(desplazamientos.get(j) + "");
            totalDesplazameintos = numA + totalDesplazameintos;
        }
        imprimir();
    }

    public void imprimir() {

        for (int i = 0; i < referencias.size(); i++) {
            if (i == referencias.size() - 1) {
                break;
            }
            if ((i + 1) == referencias.size()) {
                System.out.println(referencias.get(i));
            } else {
                System.out.println(referencias.get(i + 1) + "  " + desplazamientos.get(i));
            }
        }
        System.out.println("Desplazamientos: " + totalDesplazameintos);
        System.out.println("");
        System.out.println("");
    }
}
