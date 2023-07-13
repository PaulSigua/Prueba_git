/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listaenlazadajava;

import java.util.LinkedList;

/**
 *
 * @author UPS
 */
public class ListaEnlazadaJava {
    public static void main(String[] args) {
        LinkedList<Integer> listaEnlazada= new LinkedList();
        listaEnlazada.add(5);
        listaEnlazada.add(6);
        listaEnlazada.add(7);
        listaEnlazada.add(8);
        //inicio o fin
        listaEnlazada.addFirst(4);
        listaEnlazada.addLast(9);
        System.out.println(listaEnlazada);
        //cambiar
        listaEnlazada.set(0, 1);
        System.out.println(listaEnlazada);
        //Obtener un dato Primero, fin, posicion
        int dato = listaEnlazada.getFirst();
        dato = listaEnlazada.get(1);
        dato = listaEnlazada.getLast();
        //Eliminar primero, fin
        listaEnlazada.removeFirst();
        listaEnlazada.removeLast();
        System.out.println(listaEnlazada);
        listaEnlazada.remove(0);
        System.out.println(listaEnlazada);
        //agregar en posicion
        listaEnlazada.add(1, -1);
        System.out.println(listaEnlazada);
        //validar si existe un elemento
        System.out.println(listaEnlazada.contains(-1));
        // buscar le indice de un elemento
        System.out.println(listaEnlazada.indexOf(7));
        // tamaño de la lista
        System.out.println(listaEnlazada.size());
    }
    
}
