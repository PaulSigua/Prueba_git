/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

/**
 *
 * @author aplaza
 */
public class Inicio 
{
    public static void main (String args[])
    {
        Cuenta c=new Cuenta(1,"ana");
    
        ICuentaBancaria cuenta=new CuentaAhorroImpl();
    
        ICuentaBancaria cuentaBlindaje=new BlindajeDecorador(cuenta);

        //cuenta.abrirCuenta(c);
        
        cuentaBlindaje.abrirCuenta(c);
    }
}
