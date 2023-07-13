
package pruebaCajero;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Atender extends Thread{
    Cajero cajero;
    private int tiempo = 1000;

    public Atender(Cajero cajero, int tiempo) {
        this.cajero = cajero;
        this.tiempo = tiempo;
    }
    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(1000);
                cajero.atender();
            } catch (InterruptedException ex) {
                Logger.getLogger(Atender.class.getName()).log(Level.SEVERE, null, ex);
                Thread.currentThread().interrupt();
            }
        }
    }
}
