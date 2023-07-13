/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import modelo.Persona;
import vista.Vista;

/**
 *
 * @author Anthony Moya
 */
public class Controlador {
    WeakHashMap<String, Persona> personas;

    public Controlador(Vista vista) {
        personas = new WeakHashMap<>();
    }
    
    public void anidarPersona(String id, Persona persona){
        personas.put(id, persona);
    }
    
    public Persona buscarPersona(String id){
        return personas.get(id);
    }
    
    public void eliminarPersona(String id){
        personas.remove(id);
    }

    public void getPersonas() {
        personas.forEach((k,v) -> System.out.println("Cedula: " + k + ": Persona: " + v));
        }
    }

