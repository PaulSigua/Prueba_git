/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelos.DefaultListaPersonas;
import vista.Vista;
import vista.Vista2;
/**
 *
 * @author Alienware
 */
public class Principal {
    public static void main(String[] args){
        DefaultListaPersonas modeloLista = new DefaultListaPersonas();
        Vista v = new Vista2();
        Controlador c = new Controlador(modeloLista, v);
    }
}
