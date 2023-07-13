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
public class ListenerButtonWindowTWO implements ActionListener {

    private WindowLineTWO windowTWO;
    private Info infoModel;
    private DefaultListClient listClient;
    private ControllerRecharge controllerRecharge;
    private int id;
    private int numero;
    private ArrayList numeros = new ArrayList();

    public ListenerButtonWindowTWO(WindowLineTWO windowTWO, DefaultListClient listClient) {
        this.windowTWO = windowTWO;
        this.infoModel = new Info("", "", "", "", "");
        this.listClient = listClient;
        this.controllerRecharge = new ControllerRecharge();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        infoModel.setName(windowTWO.getNameWindow());
        infoModel.setId(windowTWO.getIdWindow());
        infoModel.setCell(windowTWO.getCellWindow());
        infoModel.setAge(windowTWO.getAgeWindow());

        if (windowTWO.getName().equals("") || windowTWO.getId().equals("")
                || windowTWO.getCell().equals("") || windowTWO.getAge().equals("")) {
            windowTWO.checkInfo();
        } else {
            try {
                int idClient = Integer.parseInt(infoModel.getId());
                int cellClient = Integer.parseInt(infoModel.getCell());
                int ageClient = Integer.parseInt(infoModel.getAge());
                boolean codRecharge = controllerRecharge.addRechargeLineTwo(generateId(),
                        infoModel.getName(), idClient, cellClient, ageClient);

                String[] info = windowTWO.getInfo();
                listClient.addElement(
                        new Info(info[0], info[1], info[2], info[3], info[4])
                );

                if (!infoModel.getName().equals("") && !infoModel.getId().equals("")
                        && !infoModel.getCell().equals("") && !infoModel.getAge().equals("")) {
                    System.out.println("Informacion linea 2 guardada");
                } else {
                    System.out.println("Informacion no guardada");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(windowTWO, "Existe "
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
