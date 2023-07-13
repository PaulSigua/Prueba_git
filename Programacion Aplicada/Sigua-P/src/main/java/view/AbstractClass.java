/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Decorator.*;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author LENOVO
 */
public abstract class AbstractClass extends JFrame
{
    public abstract String[] getDatos ();
    public abstract void actionAceptar(ActionListener listener);
}
