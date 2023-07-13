/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import vista.VistaPadre;
import modelos.ConversorModel;

/**
 *
 * @author Alienware
 */
public class Controlador {
    private VistaPadre v;
    private ConversorModel m;

    public Controlador(VistaPadre v, ConversorModel m) {
        this.v = v;
        this.m = m;
        
        ListenerModelo lm = new ListenerModelo(v);
        m.addPropertyChangeListener(lm);
        
        ListenerConvertirButton lb = new ListenerConvertirButton(v,m);
        v.addConvertirButtonListener(lb);
        
        this.v.setVisible(true);
    }
}
