/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ArbolControlador;
import java.util.Scanner;
import modelo.Nodo;

/**
 *
 * @author diego
 */
public class VistaArbol {
     Scanner teclado;
     ArbolControlador arbolControlador;

    public VistaArbol() {
        teclado = new Scanner(System.in);
        arbolControlador = new ArbolControlador();
    }
    
    public void menu(){
        int opc = 0;
        do {            
            System.out.println("--------------------------------------");
            System.out.println("Ingrese una opcion: ");
            System.out.println("1. Ingresar un numero \n2. InOrden \n3. PreOrden \n4. PosOrden \n5. Buscar\n6. Eliminar el primer elemento \n0. Salir");
            System.out.println("--------------------------------------");
            opc = teclado.nextInt();
            switch(opc){
                case 1:
                    ingresar();
                    break;
                case 2:
                    arbolControlador.inOrden(arbolControlador.getRaiz());
                    break;
                case 3:
                    arbolControlador.preOrden(arbolControlador.getRaiz());
                    break;
                case 4:
                    arbolControlador.posOrden(arbolControlador.getRaiz());
                    break;
                case 5: 
                    buscar(); 
                    break;
                case 6:
                    eliminar();
                    break;
            }
        } while (opc != 0);
    }
    public void ingresar(){
        System.out.println("Ingrese un valor");
        int valor = teclado.nextInt();
        arbolControlador.crear(new Nodo(valor), arbolControlador.getRaiz());
    }
    public void buscar(){
        System.out.println("Ingrese un valor");
        int valor = teclado.nextInt();
        Nodo nodo = arbolControlador.buscar(arbolControlador.getRaiz(), valor);
        System.out.println(nodo);
    }     
     
    public void eliminar(){
        System.out.println("Ingrese un valor");
        int valor = teclado.nextInt();
        arbolControlador.eliminar(valor);
    }
}
