
package Inicio;

import Algoritmos.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author LENOVO
 */
public class Menu {
    Scanner entrada = new Scanner(System.in);
    Vector valores = new Vector();
    List<Integer> valores2 = new ArrayList();
    AlgoritmoFCFS fcfs;
    AlgoritmoSSTF sstf;
    AlgoritmoSCAN scan;
    ALgoritmoC_SCAN c_scan;
    int opc;
    int referencias;
    int valorMin;
    int valorMax;

    public void menu() {
        System.out.println("-------------BIENVENID@------------");
        do {
            System.out.println("1. Iniciar recorrido");
            System.out.println("0. Salir");
            opc = entrada.nextInt();
            switch (opc) {
                case 1:
                    System.out.print("Ingrese el total de referencias: ");
                    referencias = entrada.nextInt();
                    for (int i = 0; i < referencias; i++) {
                        System.out.print("Ingrese la referencia " + (i + 1) + ": ");
                        int valorReferencia = entrada.nextInt();
                        valores.addElement(valorReferencia);
                        valores2.add(valorReferencia);
                    }
                    System.out.println("");
                    fcfs = new AlgoritmoFCFS(valores);
                    sstf = new AlgoritmoSSTF(valores2);
                    System.out.print("Ingrese el valor minimo para el LOGARITMO SCAN y C_SCAN: ");
                    valorMin = entrada.nextInt();
                    System.out.print("Ingrese el valor maximo para el LOGARITMO SCAN y C_SCAN: ");
                    valorMax = entrada.nextInt();
                    scan = new AlgoritmoSCAN(valores2,this.valorMin,this.valorMax);
                    c_scan = new ALgoritmoC_SCAN(valores,this.valorMin,this.valorMax);
                    fcfs.operar();
                    sstf.operar();
                    scan.operar();
                    c_scan.operar();
                     
                    break;

                case 0:
                    System.out.println("El recorrido finalizo");
                    break;

            }

        } while (opc != 0);
    }
}
