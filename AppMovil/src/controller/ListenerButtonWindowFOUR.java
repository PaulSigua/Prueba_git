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
public class ListenerButtonWindowFOUR implements ActionListener {

    private WindowLineFOUR windowFour;
    private Info infoModel;
    private DefaultListClient listClient;
    private ControllerRecharge controllerRecharge;
    private int id;
    private int numero;
    private ArrayList numeros = new ArrayList();

    public ListenerButtonWindowFOUR(WindowLineFOUR windowFour, DefaultListClient listModel) {
        this.windowFour = windowFour;
        this.infoModel = new Info("", "", "", "", "");
        this.listClient = listModel;
        this.controllerRecharge = new ControllerRecharge();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        infoModel.setName(windowFour.getNameWindow());
        infoModel.setId(windowFour.getIdWindow());
        infoModel.setCell(windowFour.getCellWindow());
        infoModel.setAge(windowFour.getAgeWindow());

        if (windowFour.getName().equals("") || windowFour.getId().equals("")
                || windowFour.getCell().equals("") || windowFour.getAge().equals("")) {
            windowFour.checkInfo();
        } else {
            try {
                int idClient = Integer.parseInt(infoModel.getId());
                int cellClient = Integer.parseInt(infoModel.getCell());
                int ageClient = Integer.parseInt(infoModel.getAge());
                boolean codRecharge = controllerRecharge.addRechargeLineFour(generateId(),
                        infoModel.getName(), idClient, cellClient, ageClient);
                
                String[] info = windowFour.getInfo();
                listClient.addElement(
                        new Info(info[0], info[1], info[2], info[3], info[4])
                );
                
                if (!infoModel.getName().equals("") && !infoModel.getId().equals("")
                        && !infoModel.getCell().equals("") && !infoModel.getAge().equals("")) {
                    System.out.println("Informacion linea 4 guardada");
                } else {
                    System.out.println("Informacion no guardada");
                }
            } catch (NumberFormatException ex) {
              JOptionPane.showMessageDialog(windowFour, "Existe "
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
