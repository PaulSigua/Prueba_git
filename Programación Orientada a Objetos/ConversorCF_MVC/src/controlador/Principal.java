/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelos.ConversorModel;
import vista.VistaPadre;
import vista.VistaPrincipal20;

/**
 *
 * @author Alienware
 */
public class Principal {
    public static void main(String[] args){
        VistaPadre v = new VistaPrincipal20();
        ConversorModel m = new ConversorModel();
        Controlador c = new Controlador(v, m);
    }
}
