
package inicio;

import java.util.Scanner;
import java.util.Vector;
import algoritmos.*;

/**
 *
 * @author LENOVO
 */
public class Menu {

    Scanner entrada = new Scanner(System.in);
    Vector valor = new Vector();
    AlgoritmoFCFS fcfs;
    AlgoritmoOptimo optimo;
    AlgoritmoLRU lru;
    int opc;
    int referencias;

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
                        valor.add(valorReferencia);
                    }
                    System.out.print("Ingrese el numero de marcos: ");
                    int numMarcos = entrada.nextInt();
                    System.out.println("");
                    fcfs = new AlgoritmoFCFS(valor, numMarcos);
                    optimo = new AlgoritmoOptimo(valor, numMarcos);
                    lru = new AlgoritmoLRU(valor, numMarcos);
                    fcfs.ejecutarFCFS();
                    optimo.ejecutarOptimo();
                    lru.ejecutarLRU();
                    valor.clear(); 
                    break;

                case 0:
                    System.out.println("El recorrido finalizo");
                    break;

            }

        } while (opc != 0);
    }
}
