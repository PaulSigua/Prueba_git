/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generico;

/**
 *
 * @author aplaza
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        General <Integer>g=new General();
        g.setAlumno(3);
        int valor=g.getAlumno();
        System.out.println (valor);
        
        General <String>g2=new General();
        g2.setAlumno("hola");
        String cadena=g2.getAlumno();
        System.out.println (cadena);
        
        Alumno a=new Alumno(15,"Ana");
        General g3=new General();
        g3.setAlumno(a);
        System.out.println (g3.getAlumno());
    }
    
}
