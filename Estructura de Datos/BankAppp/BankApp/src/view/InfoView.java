/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import cotroler.Controler;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author josev
 */
public abstract class InfoView extends JFrame {
    public abstract void setControler(Controler c);
    public abstract void setTable(DefaultTableModel d); 
    public abstract void update();
    public abstract void showModule(String module);
    public abstract void showTurn(String turn);
        

}
