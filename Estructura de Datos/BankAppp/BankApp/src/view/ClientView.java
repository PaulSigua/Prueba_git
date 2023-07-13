/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import cotroler.Controler;
import javax.swing.JFrame;
import javax.swing.ListModel;

/**
 *
 * @author josev
 */
public abstract class  ClientView extends JFrame {
     public abstract void setModelo(ListModel l);
     
     public abstract void setControler(Controler c);
     public abstract void setButtons(boolean b);
     public abstract void enableUser();
     public abstract void enableVisit();
     public abstract void clean();
                
}
