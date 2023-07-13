/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busquedasecuencial;

import java.util.Scanner;

/**
 *
 * @author UPS
 */
public class VistaPersona {
    Scanner teclado;
    ControladorPersona controladorPersona;
    public VistaPersona(){
        teclado = new Scanner(System.in);
        controladorPersona = new ControladorPersona();
    }
    public void menu(){
        int opc = 0;
        do{
            System.out.println("1. Crear");
            System.out.println("2. Busqueda Secuencial");
            System.out.println("0. Salir");
            opc = teclado.nextInt();
            switch(opc){
                case 1: crear(); break;
                case 2: buscar(); break;
            }
        }while(opc!=0);
    }
    public void crear(){
        System.out.println("Ingrese el Id:");
        long id = teclado.nextLong();
        System.out.println("Ingrese el nombre:");
        String nombre = teclado.next();
        System.out.println("Ingrese la cedula:");
        String cedula = teclado.next();
        Persona persona = new Persona(id, nombre, cedula);
        System.out.println(controladorPersona.crear(persona));
    }
    public void buscar(){
        System.out.println("Ingrese el nombre:");
        String nombre = teclado.next();
        int posicion = controladorPersona.busquedaSecuencial(nombre);
        System.out.println("Posicion de la persona = " + posicion);
    }
}
