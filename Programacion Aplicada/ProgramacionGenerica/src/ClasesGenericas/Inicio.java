/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesGenericas;

/**
 *
 * @author LENOVO
 */
public class Inicio {
    public static void main(String [] args){
        Generica <String, Persona> c = new Generica<String,Persona>();
        
        c.setDatoPersona("valor");
        Persona p = new Persona("Jh", "BH");
        c.setDatoAlumno(p);
        
        Alumno a = new Alumno("KJ", "OJ", 78);

        System.out.println(c.getDatoPersona());
        System.out.println(c.getDatoAlumno());
        
        Generica<Alumno, Persona> cp = new Generica();
        
    }
}
