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
public class RechargeListModel extends AbstractListModel<RechargeClient>{
    private ArrayList<RechargeClient> lines;

    //Constructor
    public RechargeListModel() {
        lines = new ArrayList<>();
    }

    //Métodos sobreescritos
    @Override
    public int getSize() {
        return lines.size();
    }

    @Override
    public RechargeClient getElementAt(int r) {
        return lines.get(r);
    }

    //Métodos para agregar y quitar una recarga
    public void addRecharge(RechargeClient rechargeClient){
        int index = lines.size();
        lines.add(rechargeClient);
        fireIntervalAdded(this, index, index);
    }
    
    public void removeRecharge(String rechargeClient){
        int index = lines.indexOf(rechargeClient);
        fireIntervalRemoved(this, index, index);
        lines.remove(index);
    }
    
    public void changeElement(RechargeClient recharge, int newState){
        int index = lines.indexOf(lines);
        lines.set(index, recharge);
        fireContentsChanged(this, index, index);
    }
}
