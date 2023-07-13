/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.PriorityQueue;
import modelo.Persona;

/**
 *
 * @author UPS
 */
public class ControladorPersona {
    PriorityQueue<Persona> colaPersona;
    
    public ControladorPersona(){
        colaPersona = new PriorityQueue();
    }
    public long generarId(){
        return colaPersona.isEmpty()? 1: ((Persona) colaPersona.toArray()[colaPersona.size()-1]).getId()+1;
    }
    public boolean encolar(Persona p){
        return colaPersona.offer(p);
    }
    public Persona desencolar(){
        return colaPersona.poll();
    }
    public Persona siguiente(){
        return colaPersona.peek();
    }
    public boolean eliminar(Persona p){
        return colaPersona.remove(p);
    }
    public boolean isLista(Persona p){
        return colaPersona.contains(p);
    }
    public PriorityQueue<Persona> getColaPersona() {
        return colaPersona;
    }
    public void setColaPersona(PriorityQueue<Persona> colaPersona) {
        this.colaPersona = colaPersona;
    }  
}
