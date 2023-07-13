/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prototype;

/**
 *
 * @author aplaza
 */
public class Inicio 
{
    public static void main (String args[])
    {
        RegistroEstImpl registro=new RegistroEstImpl();
        
        registro.setEstudiante("Ana");
        registro.setRegistro("académico");
        
        RegistroEstImpl registroClonado= (RegistroEstImpl) registro.clonar();
        
        System.out.println (registro);
        System.out.println (registroClonado);
        
    }
}
