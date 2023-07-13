/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author LENOVO
 */
public class PreRecharge extends AbstractListModel{
    ArrayList preRecharge;

    public PreRecharge() {
        preRecharge = new ArrayList();
    }

    @Override
    public int getSize() {
        return preRecharge.size();
    }

    @Override
    public Object getElementAt(int r) {
        return preRecharge.get(r);
    }
    
    public void addElement(Object line){
        int index = preRecharge.size();
        preRecharge.add(line);
        fireIntervalAdded(this, index, index);
    }
    
    public void removeElement(Object line){
        int index = preRecharge.indexOf(line);
        preRecharge.remove(index);
        fireIntervalRemoved(this, index, index);
    }
}
