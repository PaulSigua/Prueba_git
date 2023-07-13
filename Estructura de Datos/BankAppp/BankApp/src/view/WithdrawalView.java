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
public abstract class WithdrawalView extends JFrame{
    public abstract void setControler(Controler c);
    public abstract void setVisibleWindow(); 
    public abstract void setInfoTurns(ListModel infoModel);
    public abstract Double getDepositAmount();
    public abstract void clean();
    public abstract String getInfo();
    
}
