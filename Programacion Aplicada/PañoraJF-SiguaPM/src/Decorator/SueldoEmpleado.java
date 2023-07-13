/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class SueldoEmpleado implements ISueldo{
    
    @Override
    public void actualizarHoras(Empleado empleado) 
    {
        System.out.println("Sueldo: " + (empleado.getHora()*1.5));
    }
    
}
