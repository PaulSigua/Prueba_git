/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busquedabinaria;

import java.util.ArrayList;
import java.util.List;

public class ControladorPersona {
    private List<Persona> listPersona;
    public ControladorPersona(){
        listPersona = new ArrayList();
    }
    public boolean crear(Persona persona){
        return listPersona.add(persona);
    }

    public List<Persona> getListPersona() {
        return listPersona;
    }

    public void setListPersona(List<Persona> listPersona) {
        this.listPersona = listPersona;
    }
    
    public int busqueda(String cedula){
        int bajo = 0;
        int alto =  listPersona.size() -1;
        int posicion = -1;
        while(bajo <= alto){
            int centro = (bajo + alto)/2;
            if(listPersona.get(centro).getCedula().equals(cedula)){
                posicion = centro;
                break;
            }else if(listPersona.get(centro).getCedula().compareTo(cedula) < 0){
                alto = centro;
            }else if(listPersona.get(centro).getCedula().compareTo(cedula) > 0){
                bajo = centro +1;
            }
        }
        return posicion;
    }
    
    
    
}
