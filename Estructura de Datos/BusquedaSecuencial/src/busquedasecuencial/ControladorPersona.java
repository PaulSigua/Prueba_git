/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busquedasecuencial;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author UPS
 */
public class ControladorPersona {
    private List<Persona> listaPersona;
    public ControladorPersona(){
        listaPersona = new ArrayList();
    }
    
    public boolean crear(Persona persona){
        return listaPersona.add(persona);
    }
    public int busquedaSecuencial(String nombre){
        for (int i = 0; i < listaPersona.size(); i++) {
            Persona persona = listaPersona.get(i);
            if(persona.getNombre().equalsIgnoreCase(nombre)){
                return i;
            }
        }
        return -1;
    }
            
    
}
