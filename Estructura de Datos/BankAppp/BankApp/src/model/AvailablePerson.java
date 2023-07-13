/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Clase que nos determina la disponibilidad y existencia de un usuario o de un
//Trabajador en la base de datos

package model;

//Importación de las clases necesarias
import javax.swing.DefaultComboBoxModel;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author josev
 */
public class AvailablePerson extends DefaultComboBoxModel{
    ArrayList person;
    
    //Constructor 
    public AvailablePerson(HashMap person) {
        this.person = new ArrayList(person.values());
    }
    
    //Métodos sobre escritos de tamaño y elementos
    @Override
    public int getSize() {
        return person.size();
    }

    @Override
    public Object getElementAt(int i) {
        return person.get(i);
    }
    
}
