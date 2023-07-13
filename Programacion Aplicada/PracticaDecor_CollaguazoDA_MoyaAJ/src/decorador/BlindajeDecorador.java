/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorador;

import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.Vista;

/**
 *
 * @author Daniel Collaguazo Malla
 */
public class BlindajeDecorador extends CuentaDecorador {

    public BlindajeDecorador(ICuentaBancaria cuentaDecorada) {
        super(cuentaDecorada);
    }

    @Override
    public void abrirCuenta(Cuenta c) {
        cuentaDecorada.abrirCuenta(c);
        Vista vista = new Vista();
        if (vista.getjCheckBox1().isSelected()==true) {
            agregarSeguro(c);
        }else if (vista.getjCheckBox2().isSelected()==true) {
            agregarMillas(c);
        }
        else{
            agregarMillaSeguro(c);
    }
        
    }

    public void agregarSeguro(Cuenta c) {
        File file = new File("./src/resource/Clientes");
        try {
            PrintWriter lineNew = new PrintWriter(new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true)));
            lineNew.println("Beneficio: SEGURO");
            lineNew.close();
        } catch (HeadlessException | IOException e) {
            Logger.getLogger(CuentaAhorrosImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void agregarMillas(Cuenta c) {
        File file = new File("./src/resource/Clientes");
        try {
            PrintWriter lineNew = new PrintWriter(new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true)));
            lineNew.println("Beneficio: MILLAS");
            lineNew.close();
        } catch (HeadlessException | IOException e) {
            Logger.getLogger(CuentaAhorrosImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void agregarMillaSeguro(Cuenta c) {
        File file = new File("./src/resource/Clientes");
        try {
            PrintWriter lineNew = new PrintWriter(new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true)));
            lineNew.println("Beneficio: MILLAS y SEGURO");
            lineNew.close();
        } catch (HeadlessException | IOException e) {
            Logger.getLogger(CuentaAhorrosImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
