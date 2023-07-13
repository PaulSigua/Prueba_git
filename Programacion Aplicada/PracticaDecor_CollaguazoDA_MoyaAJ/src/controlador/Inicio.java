/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

import vista.Vista;

/**
 *
 * @author Daniel Collaguazo Malla
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vista vista = new Vista();
        CrearBoton crearBoton = new CrearBoton(vista);
        vista.crearCuenta(crearBoton);
        vista.setVisible(true);
    }
    
}
