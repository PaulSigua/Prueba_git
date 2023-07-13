package hiloSincronizado;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author LENOVO
 */
public class Asignar extends Thread {

    VentanaCliente v;
    private int tiempoCajero;
    private int tiempoCliente;
    private int x;
    private int y;
    Cajero c1 , c2 ,c3;
    ArrayList<Cliente> clientes;
    Atender atender1;
    Atender atender2;
    Atender atender3;
    private int cont = 0;
    int clienteO;
    int montoT;
    int clienteD;
    int saldoIni;
    int saldoIniT;

    public Asignar(VentanaCliente v, int tiempoCajero, int tiempoCliente, ArrayList<Cliente> clientes) {
        this.v = v;
        this.tiempoCajero = tiempoCajero;
        this.tiempoCliente = tiempoCliente;
        this.c1 = new Cajero(v, this);
        this.c2 = new Cajero(v, this);
        this.c3 = new Cajero(v, this);
        this.clientes = clientes;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("[Asignar]");
            montoT = numAleatorio(1, 100);
            clienteO = numAleatorio(1, 5);
            saldoIni = 100;
            clienteD = numAleatorio(1, 5);
            saldoIniT = numAleatorio(1, 100);
            while (clienteO == clienteD) {
                clienteD = numAleatorio(1, 5);

            }
            switch (cont) {
                case 0:
                    System.out.println("Atender 1");
                    try {
                        v.getjLabel21().setText(clienteO+"");
                        v.getjLabel23().setText(montoT+"");
                        v.getjLabel24().setText(clienteD+"");
                        v.getjLabel22().setText(saldoIni+"");
                        v.getjLabel25().setText("Ejecutando");
                        c1.atender(atender1, tiempoCajero);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Asignar.class.getName()).log(Level.SEVERE, null, ex);
                    }   cont++;
                    break;
                case 1:
                    System.out.println("Atender 2");
                    try {
                        v.getjLabel45().setText(clienteO+"");
                        v.getjLabel37().setText(montoT+"");
                        v.getjLabel38().setText(clienteD+"");
                        v.getjLabel36().setText(saldoIni+"");
                        v.getjLabel39().setText("Ejecutando");
                        c2.atender(atender2, tiempoCajero);
                        
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Asignar.class.getName()).log(Level.SEVERE, null, ex);
                    }   cont++;
                    break;
                case 2:
                    System.out.println("Atender 3");
                    try {
                        v.getjLabel55().setText(clienteO+"");
                        v.getjLabel47().setText(montoT+"");
                        v.getjLabel48().setText(clienteD+"");
                        v.getjLabel46().setText(saldoIni+"");
                        v.getjLabel49().setText("Ejecutando");
                        c3.atender(atender3, tiempoCajero);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Asignar.class.getName()).log(Level.SEVERE, null, ex);
                    }   cont = 0;
                    break;
                default:
                    break;
            }

            System.out.println("C1: " + clienteO + " C2: " + clienteD);
            
            try {
                Thread.sleep(tiempoCliente);
            } catch (InterruptedException ex) {
                //Logger.getLogger(Asignar.class.getName()).log(Level.SEVERE, null, ex);
                Thread.currentThread().interrupt();
            }
        }
        //System.out.println("Asignar: " + Thread.currentThread().isInterrupted());
    }


    public int numAleatorio(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
    
    public int getCliente(){
        return clienteO;
    }
    
    public int getMonto(){
        return montoT;
    }
    
    public int getClienteDes(){
        return clienteD;
    }
    
    public int getSaldoIni(){
        return saldoIni;
    }
    
    public int getSaldoF(){
        return saldoIni - montoT;
    }
    
    public int getSaldoIniT(){
        return saldoIniT;
    }
    
    public int getSaldoFinalT(){
        return saldoIniT + montoT;
    }
    
    public int getCont(){
        return this.cont;
    }
}
