/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.HashSet;
import java.util.Set;
import modelo.Persona;

/**
 *
 * @author diego
 */
public class ControladorPersonaSet {
    Set<Persona> listaUnicaPersona;
    
    public ControladorPersonaSet(){
        listaUnicaPersona = new HashSet();
    }
    public boolean crear(Persona p){
        return listaUnicaPersona.add(p);
    }
    public boolean eliminar(Persona p){
        return listaUnicaPersona.remove(p);
    }
    
    public Persona buscar(long id){
        for (Persona persona : listaUnicaPersona) {
            if(persona.getId() == id){
                return persona;
            }
        }
        return null;
    }
    
    public boolean actualizar(Persona pAnterior, Persona pNuevo){
        listaUnicaPersona.remove(pAnterior);
        return listaUnicaPersona.add(pNuevo);
    }

    public Set<Persona> getListaUnicaPersona() {
        return listaUnicaPersona;
    }

    public void setListaUnicaPersona(Set<Persona> listaUnicaPersona) {
        this.listaUnicaPersona = listaUnicaPersona;
    }
    
    
}
