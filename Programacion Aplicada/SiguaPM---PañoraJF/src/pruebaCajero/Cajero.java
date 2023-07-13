
package pruebaCajero;

import java.util.Random;
import java.util.Stack;

/**
 *
 * @author LENOVO
 */
public class Cajero {
    int aleatorio;

    public synchronized void asignar() throws InterruptedException {
        if (generarCliente() == 0) {
            System.out.println("---------------------------");
            System.out.println("Cajero desocupado");
            wait();
        } else {
            System.out.println("Cajero ocupado: " + "Cliente: " + this.aleatorio);
            notifyAll();
        }
    }

    public synchronized void atender() throws InterruptedException {
        if(this.aleatorio <= 1){
            System.out.println("---------------------------");
            System.out.println("Cajero en espera");
            System.out.println("Cliente: " + this.aleatorio);
            wait();
        }else if (this.aleatorio >= 1 || this.aleatorio <= 5){
            System.out.println("Cajero atendiendo al cliente: " + this.aleatorio);
            notifyAll();
        }
    }

    public Integer generarCliente() {
        Stack<Integer> numeros = new Stack<>();
        Random r = new Random();
        aleatorio = 0;
        int numeroAleatorio[] = new int[5];
        for (int i = 0; i < 5; i++) {
            aleatorio = (int) (r.nextDouble(6 - 1) + 1);
            while (numeros.contains(aleatorio)) {
                aleatorio = (int) (r.nextDouble(6 - 1) + 1);
            }
            numeros.push(aleatorio);
            numeroAleatorio[i] = aleatorio;
        }
        return aleatorio;
    }
}
