package model;

import view.*;
import controller.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class Start {
    

    public static void main(String[] args) {
        DefaultTableModel table = new DefaultTableModel();
        WindowApp windowMain = new WindowApp();
        RechargeInformation rechargeInfo = new RechargeInformation();
        WindowLineONE windowOne = new WindowLineONE(rechargeInfo);
        WindowLineTWO windowTwo = new WindowLineTWO(rechargeInfo);
        WindowLineTHREE windowThree = new WindowLineTHREE(rechargeInfo);
        WindowLineFOUR windowFour = new WindowLineFOUR(rechargeInfo);
        DefaultListClient listClient = new DefaultListClient();
        DefaultTableClient tableClient = new DefaultTableClient(listClient);
        Controller controller = new Controller(listClient, windowOne, windowTwo, windowThree, windowFour);
        
        //////////////////////////////////////////////////////////
        
        ListenerButtonONE listenerONE = new ListenerButtonONE(windowOne);
        windowMain.actionListenerButtonONE(listenerONE);

        ListenerButtonTWO listenerTWO = new ListenerButtonTWO(windowTwo);
        windowMain.actionListenerButtonTWO(listenerTWO);

        ListenerButtonTHREE listenerTHREE = new ListenerButtonTHREE(windowThree);
        windowMain.actionListenerButtonTHREE(listenerTHREE);

        ListenerButtonFOUR listenerFOUR = new ListenerButtonFOUR(windowFour);
        windowMain.actionListenerButtonFOUR(listenerFOUR);

        ListenerButtonEXIT listenerEXIT = new ListenerButtonEXIT(windowMain);
        windowMain.actionListenerButtonExit(listenerEXIT);

        windowMain.setResizable(false);
        windowMain.setVisible(true);
        rechargeInfo.setVisible(true);

    }
 
}
