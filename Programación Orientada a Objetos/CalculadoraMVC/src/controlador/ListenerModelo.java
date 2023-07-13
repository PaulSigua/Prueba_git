/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import vista.VistaCalculadora;

/**
 *
 * @author Alienware
 */
public class ListenerModelo implements PropertyChangeListener{
    VistaCalculadora v;

    public ListenerModelo(VistaCalculadora v) {
        this.v = v;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        v.borrarResultado();
        v.setResultado(evt.getNewValue().toString());
    }
}
