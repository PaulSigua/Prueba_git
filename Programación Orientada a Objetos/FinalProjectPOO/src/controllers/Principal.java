/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
//Importación de librerias/clases a usarse
import models.Recharges;
import models.CombosAndRecharges;
import models.DefaulListClients;
import models.PreRechargeModel;
import models.Recharge;
import models.RechargeListModel;
import models.Recharges;
import view.ClientWindow;
import view.ControlWindow;
import view.MainWindow;

/**
 *
 * @author LENOVO
 */
//Método Principal
public class Principal {
    public static void main(String[] args){
        //Asignación y creación de la base de datos
        CombosAndRecharges rechargesAndCombos = new CombosAndRecharges();
        Recharges line1Recharges = new Recharges(rechargesAndCombos.getAvailableLineRecharge1());
        Recharges line2Recharges = new Recharges(rechargesAndCombos.getAvailableLineRecharge2());
        Recharges line3Recharges = new Recharges(rechargesAndCombos.getAvailableLineRecharge3());
        Recharges line4Recharges = new Recharges(rechargesAndCombos.getAvailableLineRecharge4());
        Recharges line1Combo = new Recharges(rechargesAndCombos.getAvailableLine1());
        Recharges line2Combo = new Recharges(rechargesAndCombos.getAvailableLine2());
        Recharges line3Combo = new Recharges(rechargesAndCombos.getAvailableLine3());
        Recharges line4Combo = new Recharges(rechargesAndCombos.getAvailableLine4());
        
        //Inicialización de las vistas y modelos
        PreRechargeModel preRechargeModel = new PreRechargeModel();
        RechargeListModel rechargeListModel = new RechargeListModel();
        MainWindow mainWindow = new MainWindow();
        ControlWindow cw = new ControlWindow();
        mainWindow.setModelRecharges(line1Recharges, line2Recharges, line3Recharges, line4Recharges, line1Combo, line2Combo, line3Combo, line4Combo);
        ControlWindow controlWindow = new ControlWindow();
        ClientWindow clientWindow = new ClientWindow();
        DefaulListClients defaultListClient = new DefaulListClients();
        ListenerAddClient lac = new ListenerAddClient(mainWindow, preRechargeModel);
        mainWindow.addActionListenerContinueRecharge(lac);
        
        ListenerAddMaxi addMovi = new ListenerAddMaxi(mainWindow, controlWindow, rechargeListModel);
        mainWindow.addContinueButtonMovi(addMovi);
        ListenerRecharge lisRecharge = new ListenerRecharge(controlWindow, rechargeListModel);
        controlWindow.addActionListenerRecharge(lisRecharge);
        //Inicialización del controlador
        ControllerClient controlClient = new ControllerClient(defaultListClient, controlWindow, mainWindow);
        
        //Muestra por defecto las ventanas que se veran al ejecutar el programa
        mainWindow.setVisible(true);
        controlWindow.setVisible(true);
        clientWindow.setVisible(true);
        
    }
}
