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
public class RechargeModel extends AbstractListModel<Recharges>{
    private ArrayList<Recharges> recharges;
    private ArrayList<RechargeClient> recharge;

    public RechargeModel() {
        recharges = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return recharges.size();
    }

    @Override
    public Recharges getElementAt(int r) {
        return recharges.get(r);
    }
    
    public void addelementAT(RechargeClient rechargeClient){
        int index = recharge.size();
        recharge.add(rechargeClient);
        fireIntervalAdded(this, index, index);
    }
    public void addElement(Recharges recharge){
        int index = recharges.size();
        recharges.add(recharge);
        fireIntervalAdded(this, index, index);
    }

    
    public void removeElement(Recharges recharge){
        int index = recharges.indexOf(recharge);
        fireIntervalRemoved(this, index, index);
        recharges.remove(index);
    }
    
    public void changeElement(Recharges recharge, int newState){
        int index = recharges.indexOf(recharge);
        recharge.setState(newState);
        fireContentsChanged(this, index, index);
    }

}
