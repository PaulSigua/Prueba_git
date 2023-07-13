/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import vista.VentanaPrincipal;

/**
 *
 * @author UPS
 */
public class Principal {
    public static void main(String[] args){
        VentanaPrincipal v = new VentanaPrincipal();
        Controlador c = new Controlador(v);
    }
}
