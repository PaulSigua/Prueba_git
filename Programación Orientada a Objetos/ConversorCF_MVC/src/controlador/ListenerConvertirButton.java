/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaPadre;
import modelos.ConversorModel;

/**
 *
 * @author Alienware
 */
public class ListenerConvertirButton implements ActionListener{
    private VistaPadre v;
    private ConversorModel m;
    @Override
    public void actionPerformed(ActionEvent evt) {
        String texto = v.getCelsius();
        m.setCelsius(Double.parseDouble(texto));
        m.convertir();
    }

    public ListenerConvertirButton(VistaPadre v, ConversorModel m) {
        this.v = v;
        this.m = m;
    }
}
