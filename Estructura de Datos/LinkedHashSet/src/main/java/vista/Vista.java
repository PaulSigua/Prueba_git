/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorLinked;
import java.util.Random;
import java.util.Scanner;
import modelo.Numero;
import modelo.Persona;

/**
 *
 * @author LENOVO
 */
public class Vista {
    public ControladorLinked controladorLinked;
    public Scanner teclado;
    public Random random;
    
    public Vista(){
        controladorLinked = new ControladorLinked();
        teclado = new Scanner(System.in);
        random = new Random();
    }
    public void menu(){
        int opc = 0;
        do {            
            System.out.println("1. Ingresat una persona\n2. Ingresar un numero \n3. Buscar\n4. Buscar numero\n5. Listar\n6. listar los numeros\n7. eliminar persona \n8. eliminar numero \n0. Salir");
            opc = teclado.nextInt();
            switch(opc){
                case 1: crearPersona(); break;
                case 2: crearNumero(); break;
                case 3: buscarP(); break;
                case 4: buscarNum(); break;
                case 5: listarP(); break;
                case 6: listarNum(); break;
                case 7: eliminarP(); break;
                case 8: eliminarNum(); break;
            }
        } while (opc != 0);
    }
    public void crearPersona(){
        System.out.println("Ingrese Id");
        String id = teclado.next();
        System.out.println("Ingrese nombre");
        String nombre = teclado.next();
        Persona p = new Persona(id, nombre);
        System.out.println(controladorLinked.ingresar(p));
    }
    
    public void crearNumero(){
        System.out.println("Ingrese un numero par");
        int par = teclado.nextInt();
        System.out.println("Ingrese un numero impar");
        long impar = teclado.nextInt();
        Numero n = new Numero(par, impar);
        System.out.println(controladorLinked.ingresarNum(n));
    }

    
    public void buscarP(){
        System.out.println("Ingrese el id");
        String id = teclado.next();
        System.out.println("Ingrese el nombre");
        String nombre = teclado.next();
        Persona s = new Persona(id, nombre);
        System.out.println(controladorLinked.buscar(s));
    }
    public void listarP(){
        controladorLinked.getListaPersonas().forEach(p -> System.out.println(p));
    }
    public void listarNum(){
        controladorLinked.getListaNumeros().forEach(n -> System.out.println(n));
    }
    
    public void eliminarP(){
        System.out.println("Ingrese el id");
        String id = teclado.next();
        System.out.println("Ingrese el nombre");
        String nom = teclado.next();
        Persona p = new Persona(id, nom);
        System.out.println(controladorLinked.eliminar(p));
    }
    
    public void eliminarNum(){
        System.out.println("Ingrese el id");
        int par = teclado.nextInt();
        System.out.println("Ingrese el nombre");
        int impar = teclado.nextInt();
        Numero n = new Numero(par, impar);
        System.out.println(controladorLinked.eliminarNum(n));
    }
    
    public void buscarNum(){
        System.out.println("Ingrese el numero par");
        int n = teclado.nextInt();
        System.out.println("Ingrese el numero impar");
        int m = teclado.nextInt();
        Numero num = new Numero(n,m);
        System.out.println(controladorLinked.buscarNum(num));
        
    }
    
    public void generar(){
        for(int i = 0; i < 10 ; i++){
            Numero n = new Numero(i, random.nextInt(5));
            controladorLinked.generar(n);
        }
    }
    
    public void listar(){
        controladorLinked.getListaNumeros().forEach(k -> System.out.println(k));
    }
}
