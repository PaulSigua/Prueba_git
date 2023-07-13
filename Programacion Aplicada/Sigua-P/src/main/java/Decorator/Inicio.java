/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import view.VistaCuentaBancaria;
public class Inicio 
{
    public static void main (String args[])
    {
        /*Cuenta c=new Cuenta(1,"ana");
    
        ICuentaBancaria cuenta=new CuentaAhorroImpl();
    
        ICuentaBancaria cuentaBlindaje=new BlindajeDecorador(cuenta);*/

        VistaCuentaBancaria vista = new VistaCuentaBancaria();
        vista.setVisible(true);

        //cuenta.abrirCuenta(c);
        
        //cuentaBlindaje.abrirCuenta(c);
    }
}
