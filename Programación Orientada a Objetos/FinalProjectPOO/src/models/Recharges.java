/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.AbstractListModel;
/**
 *
 * @author LENOVO
 */
public class Recharges extends AbstractListModel{
    //Creación de una lista
    ArrayList combo;

    //Constructor
    public Recharges(HashMap combo) {
        this.combo = new ArrayList(combo.values());
    }

    //Métodos heredados del tamaño y elemsntos
    @Override
    public int getSize() {
        return combo.size();
    }

    @Override
    public Object getElementAt(int c) {
        return combo.get(c);
    }
    
}
