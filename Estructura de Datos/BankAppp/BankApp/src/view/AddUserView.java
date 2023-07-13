/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import cotroler.Controler;
import javax.swing.JFrame;

/**
 *
 * @author josev
 */
public abstract class AddUserView extends JFrame {
    public abstract void setControler(Controler c);
    public abstract void setVisibleWindow(); 
    public abstract String getUserName();
    public abstract String getUserMoney();
    public abstract String getUserIde();
    public abstract void clean();

    
    
}
