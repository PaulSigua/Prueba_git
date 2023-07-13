
package controllers;

import dataBase.PlayersDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;

/**
 *
 * @author mateo
 */
public class ListenerFinishConexionButton implements ActionListener{

    private WindowMain WindowMain;
    private SectionsWindow sectionsWindow;
    private PlayersDaoImpl playersDaoImpl;

    public ListenerFinishConexionButton(WindowMain windowMain, SectionsWindow sectionsWindow, PlayersDaoImpl playersDaoImpl) {
        this.sectionsWindow = sectionsWindow;
        this.WindowMain = windowMain;
        this.playersDaoImpl = playersDaoImpl;
    }
    
    
    // conectar second window con la principal
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("se cerro la ventana de las secciones");
        sectionsWindow.setVisible(false);
        
        WindowMain.setVisible(true);
    }
    
}
