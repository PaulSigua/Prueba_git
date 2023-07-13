/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.*;
import java.util.Scanner;
import modelo.Persona;

/**
 *
 * @author diego
 */
public class VistaPersona {
    public ControladorPersonaSet controladorPersonaSet;
    public Scanner teclado;
    public VistaPersona(){
        controladorPersonaSet = new ControladorPersonaSet();
        teclado = new Scanner(System.in);
    }
    public void menu(){
        int opc = 0;
        do {            
            System.out.println("1. Crear \n2. Editar\n3. Buscar\n4. Listar\n0. Salir");
            opc = teclado.nextInt();
            switch(opc){
                case 1: crear(); break;
                case 2: actualizar(); break;
                case 3: buscar(); break;
                case 4: listar(); break;
            }
        } while (opc != 0);
    }
    public void crear(){
        System.out.println("Ingrese Id");
        long id = teclado.nextLong();
        System.out.println("Ingrese nombre");
        String nombre = teclado.next();
        System.out.println("Ingrese cedula");
        String cedula = teclado.next();
        Persona p = new Persona(id, nombre, cedula);
        System.out.println(controladorPersonaSet.crear(p));
    }
    public void listar(){
        controladorPersonaSet.getListaUnicaPersona().forEach(p -> System.out.println(p));
    }
    
    public void actualizar(){
        System.out.println("Ingrese el Id a modificar:");
        long id = teclado.nextLong();
        System.out.println("Ingrese el nombre a modificar: ");
        String nombre = teclado.next();
        System.out.println("Ingrese la cedula a modificar: ");
        String cedula = teclado.next();
        Persona p = new Persona(id,nombre,cedula);
        System.out.println("Ingrese el nuevo Id: ");
        long nuevoId = teclado.nextLong();
        System.out.println("Ingrese el nuevo nombre: ");
        String nuevoNombre = teclado.next();
        System.out.println("Ingrese la nueva cedula: ");
        String nuevaCedula = teclado.next();
        Persona nuevaP = new Persona(nuevoId,nuevoNombre,nuevaCedula);
        System.out.println(controladorPersonaSet.actualizar(p, nuevaP));
    }
    
    public void buscar(){
        System.out.println("Ingrese el Id a buscar:");
        long id = teclado.nextLong();
        System.out.println(controladorPersonaSet.buscar(id));
    }
}
