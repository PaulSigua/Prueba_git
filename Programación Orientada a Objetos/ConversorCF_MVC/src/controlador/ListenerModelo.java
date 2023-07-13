/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import vista.VistaPadre;

/**
 *
 * @author Alienware
 */
public class ListenerModelo implements PropertyChangeListener{
    private VistaPadre v;
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Object obj = evt.getNewValue();
        int fahr = (int)obj;
        v.setFahrenheit(fahr);
    }

    public ListenerModelo(VistaPadre v) {
        this.v = v;
    }
    
}
