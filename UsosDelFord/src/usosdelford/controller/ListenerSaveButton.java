
package usosdelford.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import usosdelford.*;

/**
 *
 * @author mateo
 */
public class ListenerSaveButton implements ActionListener{

    private WindowFormulary windowFormulary;
    private Client client;

    public ListenerSaveButton(WindowFormulary windowFormulary) {
        this.windowFormulary = windowFormulary;
        this.client = new Client();
    }
            
    @Override
    public void actionPerformed(ActionEvent e) {
        client.setName(windowFormulary.getNameInfo());
        client.setId(windowFormulary.getIdInfo());
        client.setAge(windowFormulary.getAgeInfo());
        client.setAddress(windowFormulary.getAddressInfo());
        
        windowFormulary.getNameTextField().setText("");
        windowFormulary.getIdTextField().setText("");
        windowFormulary.getAgeTextField().setText("");
        windowFormulary.getAddressTextField().setText("");
        
        System.out.println("Nombre: " + client.getName());
        windowFormulary.saveInfoList();
        JOptionPane.showMessageDialog(windowFormulary, "Se guardo la información correctamente");
        
    }

}
