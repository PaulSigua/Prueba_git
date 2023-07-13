/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import javax.swing.JFrame;
import java.awt.event.ActionListener;

/**
 *
 * @author Alienware
 */
public abstract class VistaCalculadora extends JFrame{
    public abstract void addNumerosActionListener(ActionListener listener);
    public abstract void addOperacionesActionListener(ActionListener listener);
    public abstract void addBorrarActionListener(ActionListener listener);
    public abstract void addCalcularActionListener(ActionListener listener);
    
    public abstract void setResultado(String resultado);
    public abstract String getResultado();
    public abstract void borrarResultado();
}
