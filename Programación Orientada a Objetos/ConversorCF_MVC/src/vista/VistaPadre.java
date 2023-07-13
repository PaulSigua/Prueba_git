/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Alienware
 */
public abstract class VistaPadre extends JFrame {
    abstract public void addConvertirButtonListener(ActionListener listener);
    abstract public String getCelsius();
    abstract public void setFahrenheit(int fahr);
}
