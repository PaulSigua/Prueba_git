/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author LENOVO
 */
public abstract class Metodos extends JFrame{
    
    abstract public void conectarBateria(ActionListener listener);
    abstract public String getPorcentajeTextField();
    abstract public void setPorcentajeTextField(int porcentaje);
    
}
