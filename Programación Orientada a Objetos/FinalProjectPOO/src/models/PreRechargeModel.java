/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
//Importación de librerias/clases a usarse
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author LENOVO
 */
public class PreRechargeModel extends AbstractListModel{
    ArrayList preRecharge;

    //Constructor
    public PreRechargeModel() {
        preRecharge = new ArrayList();
    }

    //Metodo sobreescrito/heredado que nos devuelve el tamaño del Arraylist
    @Override
    public int getSize() {
        return preRecharge.size();
    }

    //Método heredado que nos devuelve un elemento entero
    @Override
    public Object getElementAt(int preR) {
        return preRecharge.get(preR);
    }
    
    //Método para agregar un elemento del tipo objeto
    public void addElement(Object line){
        int index = preRecharge.size();
        preRecharge.add(line);
        fireIntervalAdded(this, index, index);
    }
    
    //Método para remover un elemento del tipo objeto
    public void removeElement(Object line){
        int index = preRecharge.indexOf(line);
        preRecharge.remove(line);
        fireIntervalRemoved(this, index, index);
    }
}
