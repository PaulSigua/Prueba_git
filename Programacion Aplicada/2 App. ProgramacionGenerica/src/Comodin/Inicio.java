/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comodin;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aplaza
 */
public class Inicio 
{
    public static void main (String args[])
    {
        Empleado e1=new Empleado("Ana", 12);
        Empleado e2=new Empleado("Pedro", 13);
        
        Cliente c1 = new Cliente("Maria ", 40);
        Cliente c2 = new Cliente("Paul ", 20);
        
        Admin a1 = new Admin("Andres");
        Admin a2 = new Admin("David");
        
        ArrayList<Empleado> listaE=new ArrayList<>();
        ArrayList<Cliente> listaC= new ArrayList<>();
        ArrayList<Admin> listaA= new ArrayList<>();
        
        listaE.add(e1);
        listaE.add(e2);
        
        listaC.add(c1);
        listaC.add(c2);
        
        listaA.add(a1);
        listaA.add(a2);
        
        listarUpperBounded(listaE);
        listarUpperBounded(listaC);
        //listarUpperBounded(listaA);
        listarLowerBounded(listaC);
        //listarLowerBounded(listaE);
        //listarLowerBounded(listaA);
        listarUnBounded(listaA);
    } 
        
    public static void listarUpperBounded(ArrayList<? extends Persona> lista)
    {
        for(Persona c: lista)
        {
            System.out.println (c.getNombre() + c.getEdad());
        }
    }       
    
    public static void listarLowerBounded(ArrayList<? super Cliente> lista)
    {
        for(Object c: lista)
        {
            System.out.println (((Persona)c).getNombre() + ((Persona)c).getEdad());
        }
    } 
    
    public static void listarUnBounded(ArrayList<Admin> lista)
    {
        for(Object c: lista)
        {
            /*if(c instanceof Cliente)
                System.out.println (((Cliente)c).getNombre());
            if(c instanceof Empleado)
                System.out.println (((Empleado)c).getNombre());*/
            if(c instanceof Admin)
                System.out.println(((Admin)c).getNombre());
        }
        
    }
    
    /*public static void listar(ArrayList<Persona> lista)
    {
        for(Persona c: lista)
        {
            System.out.println (c.getNombre());
        }
    }*/
}
