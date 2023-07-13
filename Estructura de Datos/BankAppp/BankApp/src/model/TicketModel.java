/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Clase para definir el modelo de Tickets para las tablas 

package model;

//Importación de las librerias necesarias
import javax.swing.AbstractListModel;
import java.util.ArrayList;
/**
 *
 * @author josev
 */
public class TicketModel extends AbstractListModel {
    //Definición de el Array List que guardará los tickets 
    ArrayList<Ticket> ticketList;
    
    //Constructor
    public TicketModel(){
        ticketList = new ArrayList();
    }
    
    //Métodos heredados de tamaño y elemento
    @Override
    public int getSize() {
        return ticketList.size();
    }
    @Override
    public Ticket getElementAt(int index) {
        return ticketList.get(index);
    }
    
    //Método para poder añadir y eliminar elementos en la tabla
    public void addElement (Ticket ticket){
        int index = ticketList.size();
        ticketList.add(ticket);
        fireIntervalAdded(this, index, index);
    }
    public void removeElement(Ticket ticket){
        int index = ticketList.indexOf(ticket);
        
        ticketList.remove(index);
        fireIntervalRemoved(this, index, index);
        
    }
}
