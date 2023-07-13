
package controller;

import javax.swing.table.DefaultTableModel;
import view.*;
import model.*;

/**
 *
 * @author mateo
 */
public class Controller {
    DefaultTableClient tableClient;
    DefaultListClient listClient;
    WindowLineONE windowOne;
    WindowLineTWO windowTwo;
    WindowLineTHREE windowThree;
    WindowLineFOUR windowFour;

    public Controller(DefaultListClient listClient, WindowLineONE windowOne,
            WindowLineTWO windowTwo, WindowLineTHREE windowThree, WindowLineFOUR windowFour) {
        this.windowOne = windowOne;
        this.windowTwo = windowTwo;
        this.windowThree = windowThree;
        this.windowFour = windowFour;
        this.listClient = listClient;
        this.tableClient = new DefaultTableClient(listClient);
        
        ListenerButtonWindowONE listenerButtonONE = new ListenerButtonWindowONE(windowOne, listClient);
        windowOne.actionListenerUpload(listenerButtonONE);
        windowOne.setModelTable(tableClient);
        
        ListenerButtonCancelONE listenerCancelOne = new ListenerButtonCancelONE(windowOne);
        windowOne.actionListenerCancel(listenerCancelOne);
        
        ListenerButtonWindowTWO listenerButtonTWO = new ListenerButtonWindowTWO(windowTwo, listClient);
        windowTwo.actionListenerUpload(listenerButtonTWO);
        
        ListenerButtonCancelTWO listenerCancelTwo = new ListenerButtonCancelTWO(windowTwo);
        windowTwo.actionListenerCancel(listenerCancelTwo);
        
        ListenerButtonWindowTHREE listenerButtonThree = new ListenerButtonWindowTHREE(windowThree, listClient);
        windowThree.actionListenerUpload(listenerButtonThree);
        
        ListenerButtonCancelTHREE listenerCancelThree = new ListenerButtonCancelTHREE(windowThree);
        windowThree.actionListener(listenerCancelThree);
        
        ListenerButtonWindowFOUR listenerButtonFour = new ListenerButtonWindowFOUR(windowFour, listClient);
        windowFour.actionListenerUpload(listenerButtonFour);
        
        ListenerButtonCancelFOUR listenerCancelFour = new ListenerButtonCancelFOUR(windowFour);
        windowFour.actionListenerCancel(listenerCancelFour);
    
        
    }
    
}
