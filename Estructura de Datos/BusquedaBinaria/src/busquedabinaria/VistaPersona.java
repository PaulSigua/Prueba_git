/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busquedabinaria;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author UPS
 */
public class VistaPersona {
    public Scanner teclado;
    public ControladorPersona controladorPersona;
    public VistaPersona(){
        teclado = new Scanner(System.in);
        controladorPersona = new ControladorPersona();
    }
    public void menu(){
        int opc = 0;
        do{
            System.out.println("1. Generar");
            System.out.println("2. Buscar");
            System.out.println("3. Listar");
            System.out.println("0. Salir");
            opc = teclado.nextInt();
            switch(opc){
                case 1: generar(); break;
                case 2: buscar(); break;
                case 3:
                    listar();
                    break;
            }
        }while(opc != 0);
    }
    public void generar(){
        System.out.println("Ingrese el numero de personas a generar: ");
        int numero = teclado.nextInt();
        for (int i = 0; i < numero; i++) {
            Persona p = new Persona(i, generarCedula());
            controladorPersona.crear(p);
        }
    }
    public void buscar(){
        System.out.println("Ingrese la cedula");
        String cedula = teclado.next();
        int posicion = controladorPersona.busqueda(cedula);
        System.out.println("Posicion persona: " + posicion);
    }
    public String generarCedula(){
        String cedula = "";
        for (int i = 0; i < 10; i++) {
            cedula += new Random().nextInt(10);
        }
        return cedula;
    }
    public void listar(){
        for (Persona persona : controladorPersona.getListPersona()) {
            System.out.println(persona);
        }
    }
    
    
}
