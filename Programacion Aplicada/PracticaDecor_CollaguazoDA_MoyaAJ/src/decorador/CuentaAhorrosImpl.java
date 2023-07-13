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

/**
 *
 * @author Daniel Collaguazo Malla
 */
public class CuentaAhorrosImpl implements ICuentaBancaria {

    @Override
    public void abrirCuenta(Cuenta c) {
        File file = new File("./src/resource/Clientes");
        try {
            PrintWriter lineNew = new PrintWriter(new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true)));
            lineNew.println("Codigo: "+c.getCodigo() + " Nombre: " + c.getNombre());
            lineNew.close();
        } catch (HeadlessException | IOException e) {
            Logger.getLogger(CuentaAhorrosImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
