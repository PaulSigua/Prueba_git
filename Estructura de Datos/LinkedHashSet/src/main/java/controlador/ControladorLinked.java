/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import modelo.Numero;
import modelo.Persona;

/**
 *
 * @author LENOVO
 */
public class ControladorLinked {
    List<Persona> ListaPersonas;
    List<Numero> ListaNumeros;

    public ControladorLinked() {
        ListaPersonas = new LinkedList<>();
        ListaNumeros = new LinkedList<>();
    }
    
    public boolean ingresar(Persona p){
        return ListaPersonas.add(p);
    }  
    
    public boolean ingresarNum(Numero num){
        return ListaNumeros.add(num);
    }
    
    public boolean eliminar(Persona p){
        return ListaPersonas.remove(p);
    }
    
    public boolean eliminarNum(Numero num){
        return ListaNumeros.remove(num);
    }
    
    public boolean buscar(Persona p){
        return ListaPersonas.contains(p);
    }
    
    public boolean buscarNum(Numero num){
        return ListaNumeros.contains(num);
    }
    
    public boolean generar(Numero n){
        return ListaNumeros.add(n);
    }

    public List<Persona> getListaPersonas() {
        return ListaPersonas;
    }

    public void setListaPersonas(List<Persona> ListaPersonas) {
        this.ListaPersonas = ListaPersonas;
    }

    public List<Numero> getListaNumeros() {
        return ListaNumeros;
    }

    public void setListaNumeros(List<Numero> ListaNumeros) {
        this.ListaNumeros = ListaNumeros;
    }
    
}
