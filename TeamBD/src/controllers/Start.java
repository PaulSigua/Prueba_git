package controllers;

import dataBase.PlayersDaoImpl;
import views.*;

/**
 *
 * @author mateo
 */
public class Start {

    public static void main(String[] args) {
        WindowMain windowMain = new WindowMain();
        HelpWindow helpWindow = new HelpWindow();
        SectionsWindow sectionsWindow = new SectionsWindow();
        PlayersDaoImpl playersDaoImpl = new PlayersDaoImpl();
        windowMain.setVisible(true);
        windowMain.setResizable(false);

        ListenerOkButton listenerOk = new ListenerOkButton(windowMain, sectionsWindow);
        windowMain.actionListenerOk(listenerOk);

        ListenerMenuItemOne listenerMenuItenOne = new ListenerMenuItemOne(windowMain, helpWindow);
        windowMain.actionListenerjJRadioButtonMenuItemOne(listenerMenuItenOne);

        ListenerMenuItemTwo listenerMenuItemTwo = new ListenerMenuItemTwo(windowMain);
        windowMain.actionListenerJRadioButtonMenuItemTwo(listenerMenuItemTwo);
        
        ListenerFinishConexionButton listenerFinishConexionButton = new ListenerFinishConexionButton(windowMain, sectionsWindow, playersDaoImpl);
        sectionsWindow.actionListenerFinishConexion(listenerFinishConexionButton);
        
        ListenerSeccionOneButton listenerSeccionOneButton = new ListenerSeccionOneButton(sectionsWindow);
        sectionsWindow.actionListenerSeccionOne(listenerSeccionOneButton);
    }

}
