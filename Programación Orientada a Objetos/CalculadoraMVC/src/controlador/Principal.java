/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelos.CalculadoraModel;
import vista.VistaCalculadora;
import vista.VistaCalculadora10;

/**
 *
 * @author Alienware
 */
public class Principal {
    public static void main(String[] args){
        
        CalculadoraModel m = new CalculadoraModel();
        
        VistaCalculadora v = new VistaCalculadora10();
        
        ListenerModelo lm = new ListenerModelo(v);
        m.addPropertyChangeListener(lm);
        
        ListenerNumeros ln = new ListenerNumeros(v);
        v.addNumerosActionListener(ln);
        
        ListenerOperaciones lo = new ListenerOperaciones(v, m);
        v.addOperacionesActionListener(lo);
        
        ListenerCalcular lc = new ListenerCalcular(v, m);
        v.addCalcularActionListener(lc);
        
        ListenerBorrar lb = new ListenerBorrar(v);
        v.addBorrarActionListener(lb);
        
        v.setVisible(true);
    }
}
