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
public class ListenerButtonWindowONE implements ActionListener {

    private WindowLineONE windowONE;
    private Info infoModel;
    private DefaultListClient listClient;
    private ControllerRecharge controllerRecharge;
    private int id;
    private int numero;
    private ArrayList numeros = new ArrayList();
    
    public ListenerButtonWindowONE(WindowLineONE windowONE, DefaultListClient listClient) {
        this.windowONE = windowONE;
        this.infoModel = new Info("", "", "", "", "");
        this.listClient = listClient;
        this.controllerRecharge = new ControllerRecharge();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        infoModel.setName(windowONE.getNameWindow());
        infoModel.setId(windowONE.getIdWindow());
        infoModel.setCell(windowONE.getCellWindow());
        infoModel.setAge(windowONE.getAgeWindow());

        if (windowONE.getName().equals("") || windowONE.getId().equals("")
                || windowONE.getCell().equals("") || windowONE.getAge().equals("")) {
            windowONE.checkInfo();
        } else {
            try {
                int idClient = Integer.parseInt(infoModel.getId());
                int cellClient = Integer.parseInt(infoModel.getCell());
                int ageClient = Integer.parseInt(infoModel.getAge());
                
                boolean codRecharge = controllerRecharge.addRechargeLineOne(generateId(),
                        infoModel.getName(), idClient, cellClient, ageClient);

                String[] info = windowONE.getInfo();
                listClient.addElement(
                        new Info(info[0], info[1], info[2], info[3], info[4])
                );
                
                if (!infoModel.getName().equals("") && !infoModel.getId().equals("")
                        && !infoModel.getCell().equals("") && !infoModel.getAge().equals("")) {
                    System.out.println("Informacion linea 1 guardada");
                } else {
                    System.out.println("Informacion no guardada");
                }
                
                System.out.println("Nombre: " + infoModel.getName() + ", Cédula: " + infoModel.getId() + ", Teléfono: "
                + infoModel.getCell() + ", Edad: " + infoModel.getAge());
    
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(windowONE, "Existe "
                        + "un error en la información ingresada");
            }

        }

    }

    public int generateId() {
        for (int i = 1; i <= 5; i++) {
            numero = (int) (Math.random() * 50 + 1);
            if (numeros.contains(numero)) {
                i--;
            } else {
                numeros.add(numero);
            }
        }
        return id;
    }

}
