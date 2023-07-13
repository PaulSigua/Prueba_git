/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import vista.VistaCalculadora;

/**
 *
 * @author Alienware
 */
public class ListenerNumeros implements ActionListener{
    VistaCalculadora v;

    public ListenerNumeros(VistaCalculadora v) {
        this.v = v;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        String texto = evt.getActionCommand();
        v.setResultado(texto);
    }
    
}
