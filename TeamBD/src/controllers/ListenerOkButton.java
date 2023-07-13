package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;
import models.*;
import dataBase.*;

/**
 *
 * @author mateo
 */
public class ListenerOkButton implements ActionListener {

    private WindowMain windowMain;
    private Players players;
    private int id;
    private String name;
    private String password;
    private int age;
    private String possession;
    private Controller controller;
    private SectionsWindow sectionsWindow;

    public ListenerOkButton(WindowMain windowMain, SectionsWindow sectionsWindow) {
        this.windowMain = windowMain;
        this.players = new Players("", "", 0, "");
        this.controller = new Controller();
        this.sectionsWindow = sectionsWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        name = windowMain.getNamePlayer();
        password = windowMain.getPasswordPlayer();
        age = windowMain.getAgePlayer();
        possession = windowMain.getPossessionPlayer();

        if (windowMain.getNamePlayer().equals("") || windowMain
                .getPasswordPlayer().equals("")) {
            windowMain.checkInfo();
        } else {

            windowMain.getNameTextField().setText("");
            windowMain.getPasswordField().setText("");
            players = new Players(name, password, age, possession);
            boolean addPlayer = controller.addlogic(getIdPlayer(), name,
                    password, age, possession);

            System.out.println("Nombre: " + name + ", Contraseña: " + password
                    + ", Edad: " + age + ", Posición: " + possession);
            windowMain.fillComboBox();

            windowMain.setVisible(false);
            sectionsWindow.setVisible(true);
        }

    }

    public int getIdPlayer() {
        return id;
    }
}
