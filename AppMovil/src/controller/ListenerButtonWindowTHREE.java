package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.*;
import model.*;

/**
 *
 * @author mateo
 */
public class ListenerButtonWindowTHREE implements ActionListener {

    private WindowLineTHREE windowThree;
    private Info infoModel;
    private DefaultListClient listClient;
    private ControllerRecharge controllerRecharge;
    private int id;
    private int numero;
    private ArrayList numeros = new ArrayList();

    public ListenerButtonWindowTHREE(WindowLineTHREE windowThree, DefaultListClient listModel) {
        this.windowThree = windowThree;
        this.infoModel = new Info("", "", "", "", "");
        this.listClient = listModel;
        this.controllerRecharge = new ControllerRecharge();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        infoModel.setName(windowThree.getNameWindow());
        infoModel.setId(windowThree.getIdWindow());
        infoModel.setCell(windowThree.getCellWindow());
        infoModel.setAge(windowThree.getAgeWindow());

        if (windowThree.getName().equals("") || windowThree.getId().equals("")
                || windowThree.getCell().equals("") || windowThree.getAge().equals("")) {
            windowThree.checkInfo();
        } else {
            try {
                int idClient = Integer.parseInt(infoModel.getId());
                int cellClient = Integer.parseInt(infoModel.getCell());
                int ageClient = Integer.parseInt(infoModel.getAge());
                boolean codRecharge = controllerRecharge.addRechargeLineThree(generateId(),
                        infoModel.getName(), idClient, cellClient, ageClient);
                
                String[] info = windowThree.getInfo();
                listClient.addElement(
                        new Info(info[0], info[1], info[2], info[3], info[4])
                );
                
                if (!infoModel.getName().equals("") && !infoModel.getId().equals("")
                        && !infoModel.getCell().equals("") && !infoModel.getAge().equals("")) {
                    System.out.println("Informacion linea 3 guardada");
                } else {
                    System.out.println("Informacion no guardada");
                }
            } catch (NumberFormatException ex) {
               JOptionPane.showMessageDialog(windowThree, "Existe "
                        + "un error en la información ingresada");
            }

        }
    }
    
    public int generateId(){
        return id;
    }
}
