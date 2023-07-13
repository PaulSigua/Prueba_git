/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasespropias;

/**
 *
 * @author LENOVO
 */
public class Main {
    public static void main(String[] args){
        
        Pareja<String> uno = new Pareja<String>();
        
        uno.setPrimero("Mateo");
        
        System.out.println(uno.getPrimero());
        
        Persona persona1 = new Persona("Maria");
        
        Pareja<Persona> otro  = new Pareja<Persona>();
        
        otro.setPrimero(persona1);
        
        System.out.println(otro.getPrimero());
    }
}

class Persona{
    private String nombre;
    
    public Persona(String nombre){
        this.nombre = nombre;
    }
    
    /*@Override
    public String toString() {
        return "Persona{" + "nombre:" + nombre + '}';
    }*/
    
}
