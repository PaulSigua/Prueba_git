/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorJugador;
import java.util.Scanner;
import modelo.Jugador;

/**
 *
 * @author UPS
 */
public class VistaJugador {
    
    ControladorJugador controladorJugador;
    Scanner teclado;
    public VistaJugador(ControladorJugador controladorJugador){
        this.controladorJugador = controladorJugador;
        this.teclado = new Scanner(System.in);
    }
    
    public void menu(){
        int opc = 0;
        do {            
            System.out.println("1. Crear \n2. Listar \n0. Salir");
            opc = teclado.nextInt();
            switch(opc) {
                case 1: crear(); break;
                case 2: listar(); break;
            }
        } while (opc != 0);
    }
    public void crear(){
        System.out.println("Nombre: ");
        String nombre = teclado.next();
        System.out.println("Posicion");
        String posicion = teclado.next();
        System.out.println("Numero/Dorsal");
        int numero = teclado.nextInt();
        Jugador jugador = new Jugador(controladorJugador.generarId(), numero, nombre, posicion);
        System.out.println(controladorJugador.crear(jugador));
    }
    public void listar(){
        controladorJugador.getMapJugadores().forEach((k,v)-> System.out.println(k + " -> " + v));
    }
    
}
