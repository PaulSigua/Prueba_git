package hiloSincronizado;

import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Atender extends Thread {

    Cajero c;
    private VentanaCliente v;
    private int tiempo;
    private boolean estado;

    public Atender(Cajero c, VentanaCliente v, int tiempo, boolean estado) {
        this.c = c;
        this.v = v;
        this.tiempo = tiempo;
        this.estado = estado;
    }

    @Override
    public void run() {

        try {
            
            estado = false;
            Thread.sleep(tiempo);
            
            c.setEstado(false);
            c.notificarTodos();
            v.agregarInfo();
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Atender.class.getName()).log(Level.SEVERE, null, ex);
            Thread.currentThread().interrupt();
        }

    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
