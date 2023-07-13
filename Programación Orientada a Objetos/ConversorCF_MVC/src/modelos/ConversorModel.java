/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Alienware
 */
public class ConversorModel {
    private double celsius;
    private int fahrenheit;
    private PropertyChangeSupport mPcs = new PropertyChangeSupport(this);
    
    public void convertir(){
        int viejoFahrenheit = fahrenheit;
        double temp = celsius *1.8 + 32;
        fahrenheit = (int)temp;
        mPcs.firePropertyChange("fahrenheit", viejoFahrenheit, fahrenheit);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener){
        mPcs.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener){
        mPcs.removePropertyChangeListener(listener);
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public int getFahrenheit() {
        return fahrenheit;
    }
}
