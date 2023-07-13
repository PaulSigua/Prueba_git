/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author LENOVO
 */
public class Nodo {
    private String placa;
    private Nodo siguiente;
    private Nodo anterior;
    public Nodo(String placa){
        this.placa = placa;
        this.siguiente = null;
        this.anterior = null;
    }

    public Nodo(String placa, Nodo siguiente) {
        this.placa = placa;
        this.siguiente = siguiente;
    }

    public Nodo(String placa, Nodo siguiente, Nodo anterior) {
        this.placa = placa;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + placa +'}';
    }
}
