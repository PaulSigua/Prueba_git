/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principalWeak;

import controlador.Controlador;
import vista.Vista;

/**
 *
 * @author LENOVO
 */
public class Principal {
    public static void main(String[] args) {
        Vista vistaWeak = new Vista();
        Controlador controlador = new Controlador(vistaWeak);
        vistaWeak.setControlador(controlador);
        vistaWeak.menu();
    }
}
