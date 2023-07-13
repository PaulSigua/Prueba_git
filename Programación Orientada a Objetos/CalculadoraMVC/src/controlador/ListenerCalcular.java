/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaCalculadora;
import modelos.CalculadoraModel;

/**
 *
 * @author Alienware
 */
public class ListenerCalcular implements ActionListener{
    VistaCalculadora v;
    CalculadoraModel m;

    public ListenerCalcular(VistaCalculadora v, CalculadoraModel m) {
        this.v = v;
        this.m = m;
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        String texto = v.getResultado();
        m.setOp2(Double.parseDouble(texto));
        m.calcular();
    }
    
}
