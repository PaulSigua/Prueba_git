/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.SortedSet;
import java.util.PriorityQueue;
import java.util.TreeSet;
import modelo.Persona;

/**
 *
 * @author UPS
 */
public class ControladorPersona implements Comparable<Persona>{
    TreeSet<Persona> listaPersona;
    
    
    public ControladorPersona(){
        listaPersona = new TreeSet<>();
    }
    
    public boolean agregarPersona(Persona persona){
        return listaPersona.add(persona);
    }
    
    public long generarId(){
        return listaPersona.isEmpty()? 1: ((Persona) listaPersona.toArray()[listaPersona.size()-1]).getId()+1;
    }

    public boolean eliminar(Persona persona){
        return listaPersona.remove(persona);
    }

    public boolean buscarPersona(Persona p){
        return listaPersona.contains(p);
    }

    public TreeSet<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setColaPersona(TreeSet<Persona> colaPersona) {
        this.listaPersona = colaPersona;
    }
        
    @Override
    public int compareTo(Persona p) {
        return p.getNombre().compareTo(p.getNombre());
    }
    
}
