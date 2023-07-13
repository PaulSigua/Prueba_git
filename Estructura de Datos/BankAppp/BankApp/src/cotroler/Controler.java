/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cotroler;

//Importación de librerías necesarias
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import javax.swing.table.TableModel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import javax.swing.ListModel;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Dimension;
import java.io.FileWriter;
import java.io.File;
import model.*;
import view.*;

/**
 *
 * @author josev
 */
//Método del controlador
public class Controler {

    //Definición de todos los elementos a utilizar
    ArrayList<Dependent> dependents;
    ArrayList<Ticket> ticketsList;
    ArrayList<Ticket> tickets;
    private Ticket newTicket;
    ArrayList<User> allUsers;
    GraphicView graphicView;
    DepositView depositView;
    WithdrawalView withView;
    DefaultTableModel model;
    DataBase availableUser;
    WorkerView workerView;
    ClientView clientView;
    ArrayList<User> users;
    AddUserView addView;
    GradeView gradeView;
    InfoView infoView;
    TicketModel tm;
    UserModel um;
    private int numTicket;

    //Inicialización de las ventanas y métodos
    public Controler(ClientView clientView, 
            InfoView infoView, 
            WorkerView workerView, 
            DepositView depositView, 
            WithdrawalView withView, 
            AddUserView addView, 
            GradeView gradeView, 
            GraphicView graphicView, 
            DataBase availableUser, 
            TicketModel tm, 
            UserModel um) {
        
        this.availableUser = new DataBase();
        this.ticketsList = new ArrayList();
        this.dependents = new ArrayList();
        this.allUsers = new ArrayList();
        this.depositView = depositView;
        this.graphicView = graphicView;
        this.tickets = new ArrayList();
        this.clientView = clientView;
        this.users = new ArrayList();
        this.workerView = workerView;
        this.gradeView = gradeView;
        this.withView = withView;
        this.infoView = infoView;                        
        this.addView = addView;                
        this.numTicket = 1;                
        this.tm = tm;
        this.um = um;
    }
    
    //Implementación de los controladores a las distintas ventanas
    public void setControler(Controler c) {
        graphicView.setControler(c);
        depositView.setControler(c);
        workerView.setControler(c);
        clientView.setControler(c);
        gradeView.setControler(c);
        infoView.setControler(c);                
        withView.setControler(c);
        addView.setControler(c);                
    }
    
    

    public void makeGraphic() {
        //Configurar los distintos parametros para el gráfico
        ArrayList<Integer> grades = new ArrayList<Integer>();
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        graphicView.setVisibleWindow();
        for (Dependent dependent : availableUser.getSelectedDependent()) {
            grades.add(dependent.getGrade());
            data.setValue(dependent.getGrade(), "Puntuación", dependent.getName());
        }
        JFreeChart barGraphic = ChartFactory.createBarChart3D(
                "Promedio de puntuación",
                "Trabajadores",
                "Calificación",
                data,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartPanel panel = new ChartPanel(barGraphic);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(600, 300));
        graphicView.showGraphic(panel);
    }

}