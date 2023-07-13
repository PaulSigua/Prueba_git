/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import decorador.BlindajeDecorador;
import decorador.Cuenta;
import decorador.CuentaAhorrosImpl;
import decorador.ICuentaBancaria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Vista;

/**
 *
 * @author Daniel Collaguazo Malla
 */
public class CrearBoton implements ActionListener {

    Vista vista;

    public CrearBoton(Vista vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Cuenta cuenta = new Cuenta(Integer.parseInt(vista.getCodigoTextField().getText()), vista.getNombreTextField().getText());
        ICuentaBancaria cuentaBancaria = new CuentaAhorrosImpl();
        if (vista.getjCheckBox1().isSelected()==false & vista.getjCheckBox2().isSelected()==false) {
            cuentaBancaria.abrirCuenta(cuenta);
        } else {
            ICuentaBancaria cuentaBlindaje = new BlindajeDecorador(cuentaBancaria);
            cuentaBlindaje.abrirCuenta(cuenta);
        }
    }

}
