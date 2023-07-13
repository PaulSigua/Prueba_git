/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Nodo;

/**
 *
 * @author UPS
 */
public class ControladorListaEnlazada {
    
    private Nodo raiz; // Referencia Inicial de la lista
    
    public ControladorListaEnlazada(){
        raiz = null;
    }
    
    public void ingresarInicio(int dato){
        if(raiz == null){
            raiz = new Nodo(dato);
        }else {
            Nodo aux = new Nodo(dato, raiz);
            raiz.setAnterior(aux);
            raiz = aux;
        }
    }
    public void ingresarFin(int dato){
        if(raiz == null){
            raiz = new Nodo(dato);
        }else {
            Nodo aux = raiz;
            while(aux.getSiguiente()!=null){
                aux = aux.getSiguiente();
            }
            Nodo crear = new Nodo(dato, null, aux);
            aux.setSiguiente(crear);
        }
    }
    public void eliminarNodo(int dato){
        if(raiz.getDato() == dato){
            raiz = raiz.getSiguiente();
        }else{
            Nodo aux = raiz;
            while(aux.getSiguiente().getDato() != dato){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(aux.getSiguiente().getSiguiente());
            aux.getSiguiente().getSiguiente().setAnterior(aux);
        }
    }
    public Nodo buscarNodo(int dato){
        Nodo aux = raiz;
        while (aux.getDato() != dato) {            
            aux = aux.getSiguiente();
        }
        return aux;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
   
}
