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
public class ListenerOperaciones implements ActionListener{
    
    VistaCalculadora v;
    CalculadoraModel m;

    public ListenerOperaciones(VistaCalculadora v, CalculadoraModel m) {
        this.v = v;
        this.m = m;
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        String texto = v.getResultado();
        Double numero = Double.parseDouble(texto);
        m.setOp1(numero); //m.setOp1(Double.parseDouble(v.getResultado()));
        String operacion = evt.getActionCommand();
        switch (operacion) {
            case "+":
                m.setOperacion(0);
                break;
            case "-":
                m.setOperacion(1);
                break;
            case "*":
                m.setOperacion(2);
                break;
            case "/":
                m.setOperacion(3);
                break;
            default:
                break;
        }
        v.borrarResultado();
    }
    
}
