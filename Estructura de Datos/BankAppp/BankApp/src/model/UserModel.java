/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Clase para determinar el modelo de los usuarios 

package model;

//Importación de librerias necesarias
import javax.swing.AbstractListModel;
import java.util.ArrayList;


/**
 *
 * @author josev
 */
public class UserModel extends AbstractListModel {
    //Creación del Array List necesaria
    ArrayList<String> userDataList;
    
    //Constructor
    public UserModel(){
        userDataList = new ArrayList();
    }
    
    //Métodos heredados de tamaño y elemento
    @Override
    public int getSize() {
        return userDataList.size();
    }
    @Override
    public String getElementAt(int index) {
        return userDataList.get(index);
    }
    
    //Métodos para añadir o eliminar elementos del modelo
    public void addElement (String dato){
        int index = userDataList.size();
        userDataList.add(dato);
        fireIntervalAdded(this, index, index);
    }    
    public void removeElement(String ticket){
        int index = userDataList.indexOf(ticket);
        
        userDataList.remove(index);
        fireIntervalRemoved(this, index, index);
        
    }

    
}
