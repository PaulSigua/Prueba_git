/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import cotroler.Controler;
import javax.swing.ComboBoxModel;
import javax.swing.JFrame;
import javax.swing.ListModel;
import model.Dependent;
import model.Ticket;

/**
 *
 * @author josev
 */
public abstract class WorkerView extends JFrame {
    public abstract void update();
    public abstract void setControler(Controler c);
    public abstract void setModelDependents(ComboBoxModel dependentModel);
    public abstract void setModelTurns(ListModel turnsModel);
    public abstract int getSelectedTicket();
    public abstract Ticket getSelectedTicketItem();
    public abstract String getDependentName();
    public abstract void setVisibleWindow();
    public abstract Object getDependent();
    
    

}
