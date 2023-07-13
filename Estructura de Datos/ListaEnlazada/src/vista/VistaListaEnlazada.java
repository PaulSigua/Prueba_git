/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorListaEnlazada;
import java.util.Scanner;
import modelo.Nodo;

/**
 *
 * @author UPS
 */
public class VistaListaEnlazada {
    ControladorListaEnlazada listaEnlazada;
    Scanner teclado;
    public VistaListaEnlazada() {
        listaEnlazada = new ControladorListaEnlazada();
        teclado = new Scanner(System.in);
    }
    public void menu(){
        int opc = 0;
        do{
            System.out.println("1. Ingresar Inicio\n2. Ingresar Fin\n3. Buscar\n4. Eliminar\n5.Listar\n0.Salir");
            opc = teclado.nextInt();
            switch(opc){
                case 1: ingresarInicio(); break;
                case 2: ingresarFin(); break;
                case 3: buscar(); break;
                case 4: eliminar(); break;
                case 5: imprimir();break;
            }
        }while(opc!=0);
    }
    public void ingresarInicio(){
        System.out.println("Ingrese un valor");
        int dato = teclado.nextInt();
        listaEnlazada.ingresarInicio(dato);
    }
    public void ingresarFin(){
        System.out.println("Ingrese un valor");
        int dato = teclado.nextInt();
        listaEnlazada.ingresarFin(dato);
    }
    public void buscar(){
        System.out.println("Ingrese un valor");
        int dato = teclado.nextInt();
        System.out.println(listaEnlazada.buscarNodo(dato));
    }
    public void eliminar(){
        System.out.println("Ingrese un valor");
        int dato = teclado.nextInt();
        listaEnlazada.eliminarNodo(dato);
    }
    public void imprimir() {
        System.out.println("Recorrido hacia adelante");
        Nodo aux = listaEnlazada.getRaiz();
        Nodo fin = listaEnlazada.getRaiz();
        while (aux!= null) {            
            System.out.println(aux);
            aux = aux.getSiguiente();
            if(aux != null && aux.getSiguiente() == null) {
                fin = aux;
            }
        }
        System.out.println("Recorrido hacia atras");
        while(fin != null){
            System.out.println(fin);
            fin = fin.getAnterior();
        }
    }
    
}
