/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import java.util.Scanner;

/**
 *
 * @author aplaza
 */
public abstract class SueldoDecorador implements ISueldo
{
    protected ISueldo sueldo;

    public SueldoDecorador(ISueldo sueldo) {
        this.sueldo = sueldo;
    }
    
    @Override
    public void actualizarHoras(Empleado empleado) 
    {
        this.sueldo.actualizarHoras(empleado);
    }
}
