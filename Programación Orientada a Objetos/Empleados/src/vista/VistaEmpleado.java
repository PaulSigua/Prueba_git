/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorEmpleado;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Empleado;

/**
 *
 * @author UPS
 */
public class VistaEmpleado {
    ControladorEmpleado controladorEmpleado;
    Scanner teclado;
    public VistaEmpleado(){
        controladorEmpleado = new ControladorEmpleado();
        teclado = new Scanner(System.in);
    }
    public void menu(){
        int opc =0;
        do {            
            System.out.println("1. Crear");
            System.out.println("2. Listar");
            System.out.println("3. Ordenar");
            System.out.println("0. Salir");
            opc = teclado.nextInt();
            switch(opc){
                case 1:crear(); break;
                case 2: controladorEmpleado.listar(); break;
                case 3: controladorEmpleado.ordenarShellBySueldo(); break;
            }    
        } while (opc != 0);
    }
    public void crear(){
        System.out.println("Ingrese el id");
        int id = teclado.nextInt();
        System.out.println("Ingrese el nombre");
        String nombre = teclado.next();
        System.out.println("Ingrese el sueldo");
        double sueldo = teclado.nextDouble();
        Empleado empleado = new Empleado(id, nombre, sueldo);
        System.out.println(controladorEmpleado.crear(empleado));
    }
}
