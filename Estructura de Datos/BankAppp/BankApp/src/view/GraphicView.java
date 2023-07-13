/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import cotroler.Controler;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author josev
 */
public abstract class GraphicView extends JFrame {
    public abstract void setControler(Controler c);
    public abstract void setVisibleWindow();
    public abstract void showGraphic(JPanel panel);
}
