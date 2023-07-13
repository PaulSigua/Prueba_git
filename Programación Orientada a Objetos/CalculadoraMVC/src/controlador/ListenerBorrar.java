/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaCalculadora;

/**
 *
 * @author Alienware
 */
public class ListenerBorrar implements ActionListener{
    VistaCalculadora v;

    public ListenerBorrar(VistaCalculadora v) {
        this.v = v;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        v.borrarResultado();
    }
    
}
