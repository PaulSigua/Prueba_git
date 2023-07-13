package hilo;

import java.awt.Point;
import java.awt.event.ActionEvent;

/**
 *
 * @author LENOVO
 */
public class Hilo extends Thread {

    int tiempo;
    VentanaTragamonedas v;
    ActionEvent evt;
    int id;

    public Hilo(int tiempo, VentanaTragamonedas v, ActionEvent evt, int id) {
        this.tiempo = tiempo;
        this.v = v;
        this.evt = evt;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().isInterrupted());
        while (!Thread.currentThread().isInterrupted()) {

            if (evt.getSource().equals(v.getIniciar1Button())) {

                if (id == 1) {
                    moverFila1();
                }
            } else if (evt.getSource().equals(v.getIniciar2Button())) {
                if (id == 2) {
                    moverFila2();
                }
            } else if (evt.getSource().equals(v.getIniciar3Button())) {
                if (id == 3) {
                    moverFila3();
                }
            } else if (evt.getSource().equals(v.getIniciarTodosButton())) {
                if (id == 1) {
                    moverFila1();
                } else if (id == 2) {
                    moverFila2();
                } else if (id == 3) {
                    moverFila3();
                }
            }

            try {
                Thread.sleep(tiempo);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().isInterrupted());
    }

    public void moverFila1() {
        Point punto = v.getjLabel1().getLocation();
        v.getjLabel1().setLocation(v.getjLabel2().getLocation());
        v.getjLabel2().setLocation(v.getjLabel3().getLocation());
        v.getjLabel3().setLocation(v.getjLabel4().getLocation());
        v.getjLabel4().setLocation(punto);
        //System.out.println("Jlabel 1 Fila 1"+v.getjLabel1().getLocation());
    }

    public void moverFila2() {
        Point punto2 = v.getjLabel6().getLocation();
        v.getjLabel6().setLocation(v.getjLabel7().getLocation());
        v.getjLabel7().setLocation(v.getjLabel8().getLocation());
        v.getjLabel8().setLocation(v.getjLabel15().getLocation());
        v.getjLabel15().setLocation(punto2);
        //System.out.println("Jlabel 6 Fila 2"+v.getjLabel6().getLocation());
    }

    public void moverFila3() {
        Point punto3 = v.getjLabel9().getLocation();
        v.getjLabel9().setLocation(v.getjLabel10().getLocation());
        v.getjLabel10().setLocation(v.getjLabel12().getLocation());
        v.getjLabel12().setLocation(v.getjLabel5().getLocation());
        v.getjLabel5().setLocation(punto3);
        //System.out.println("Jlabel 9 Fila 3"+v.getjLabel9().getLocation());
    }

}
