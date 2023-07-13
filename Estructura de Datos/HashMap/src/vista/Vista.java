/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.util.Scanner;
import modelo.Persona;

/**
 *
 * @author Anthony Moya
 */
public class Vista {
    Controlador controlador;
    Scanner s;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        s = new Scanner(System.in);
    }
    
    public void menu(){
        int opc = 0;
        do{
            System.out.println("Ingrese una opcion: ");
            System.out.println("1. Crear");
            System.out.println("2. Buscar");
            System.out.println("3. Borrar");
            System.out.println("4. Listar");
            System.out.println("0. Salir");
            opc = s.nextInt();
            switch(opc){
                case 1:
                    System.out.println("Ingrese su nombre: ");
                    String nombre = s.next();
                    System.out.println("Ingrese su apellido: ");
                    String apellido = s.next();
                    System.out.println("Ingrese su edad: ");
                    int edad = s.nextInt();
                    System.out.println("Ingrese su Id: ");
                    String id = s.next();
                    controlador.anidarPersona(id, new Persona(nombre,apellido,edad));
                    break;
                case 2:
                    System.out.println("Ingrese el id: ");
                    String ids = s.next();
                    System.out.println(controlador.buscarPersona(ids).toString());
                    break;
                case 3:
                    System.out.println("Ingrese el id: ");
                    String idss = s.next();
                    controlador.eliminarPersona(idss);
                    break;
                case 4:
                    controlador.getPersonas();
                    break;
            }
        }while(opc != 0);
    }
    
}
