/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cotroler;

//Importación de las interfaces y clases necesarias
import model.*;
import view.*;

/**
 *
 * @author josev
 */
public class Main {
   public static void main(String[] args){
       //Creación y asignación de la base de datos de usuarios y trabajadores 
       DataBase udb = new DataBase();
        AvailablePerson dependentsList = new AvailablePerson(udb.getAvailableDependet());
        
        //Inicialización de las distintas vetanas y clases a utilizar
        WithdrawalView withView = new WithdrawalWindowView();
        GraphicView graphicView = new GraphicWindowView();
        DepositView depWindow = new DepositWindowView();
        AddUserView addView = new AddUserWindowView();
        WorkerView wrkview = new WorkerWindowView();
        ClientView cltview = new ClientWindowView();
        GradeView gradeView = new GradeWindowView();
        TicketModel ticketModel = new TicketModel();        
        InfoView infview = new InfoWindowView();                
        UserModel userModel = new UserModel();
        
        //Asignación de modelos para lista y tablas
        gradeView.setModelDependents(dependentsList);
        wrkview.setModelDependents(dependentsList);
        
        //Inicialización del controlador
        Controler c = new Controler(cltview, infview, wrkview, depWindow, withView, addView, gradeView, graphicView, udb, ticketModel, userModel);
        c.setControler(c);
        
        //Mostrar las ventanas que se deben ver al inicio
        wrkview.setVisible(true);
        infview.setVisible(true);
        cltview.setVisible(true);
   }
   
}
