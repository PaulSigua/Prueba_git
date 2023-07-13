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
public class CuentaAhorroImpl implements ICuentaBancaria
{

    @Override
    public void abrirCuenta(Cuenta c) 
    {
        System.out.println("Cuenta de ahorro: "+c.getCliente());
    }
    
}
