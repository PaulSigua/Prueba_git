/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciageneric;

/**
 *
 * @author aplaza
 */
public class Inicio 
{
    public static void main (String args[])
    {
        /*Persona administrativo=new Persona(01,"Ana",45);
        
        Cliente jefe=new Cliente(02,"Pedro",35);
        
        Persona nuevoAdmin=jefe;*/
        
        Generica <Persona> administrativo=new Generica<Persona>();
        administrativo.setDato(new Persona(01,"Ana",45));
        
        Generica <Cliente> jefe=new Generica<Cliente>();
        jefe.setDato(new Cliente(02,"Pedro",35));
        
        //Generica <Persona> nuevoAdmin=jefe;
        
        Generica.imprimir(administrativo);
        
        Generica.imprimir(jefe);
    }
}
