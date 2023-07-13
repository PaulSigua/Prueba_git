/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorPersona;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import modelo.Persona;

/**
 *
 * @author UPS
 */
public class VistaPersona {
    public Scanner teclado;
    public ControladorPersona controladorPersona;
    public Random random;
    
    public VistaPersona(){
        teclado = new Scanner(System.in);
        controladorPersona = new ControladorPersona();
        random = new Random();
    }
    public void menu(){
        int opc = 0;
        do {            
            System.out.println("1. Crear \n2. Buscar \n3. Eliminar \n4. Listar \n0. Salir");
            opc = teclado.nextInt();
            switch(opc) {
                case 1: crearPersona(); break;
                case 2: buscarPersona(); break;
                case 3: eliminarPersona(); break;
                case 4: listar(); break;
          }
        } while (opc != 0);
    }
    public void crearPersona(){
        System.out.println("Ingrese Id");
        int id = teclado.nextInt();
        System.out.println("Ingrese nombre");
        String nombre = teclado.next();
        Persona p = new Persona(id, nombre);
        System.out.println(controladorPersona.agregarPersona(p));
    }
    
    public void buscarPersona(){
        System.out.println("Ingrese el id");
        int id = teclado.nextInt();
        System.out.println("Ingrese el nombre");
        String nombre = teclado.next();
        Persona s = new Persona(id, nombre);
        System.out.println(controladorPersona.buscarPersona(s));
    }
    
    public void eliminarPersona(){
        System.out.println("Ingrese el id");
        int id = teclado.nextInt();
        System.out.println("Ingrese el nombre");
        String nom = teclado.next();
        System.out.println("Ingrese la prioridad");
        Persona p = new Persona(id, nom);
        System.out.println(controladorPersona.eliminar(p));
    }
    
    public void listar(){
        controladorPersona.getListaPersona().forEach(p -> System.out.println(p));
    }
    
}
