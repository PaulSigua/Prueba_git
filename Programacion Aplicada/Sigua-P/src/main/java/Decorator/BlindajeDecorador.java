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
public class BlindajeDecorador extends CuentaDecorador
{
    
    public BlindajeDecorador(ICuentaBancaria cuentaDecorada) {
        super(cuentaDecorada);
    }
    
    @Override
    public void abrirCuenta(Cuenta c)
    {
        cuentaDecorada.abrirCuenta(c); //opción básica
        agregarBlindaje(c); //opción adicional
    }
    
    public void agregarBlindaje(Cuenta c) //opción adicional o extra
    {
        System.out.println("Agregó blindaje a la cuenta: "+c.getCliente());
    }
}
