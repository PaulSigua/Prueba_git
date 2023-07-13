/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author LENOVO
 */
public class RechargeState extends AbstractListModel<Recharges>{
    private ArrayList<Recharges> recharges;
    private RechargeModel rechargeModel;
    private int state;

    @Override
    public int getSize() {
        return recharges.size();
    }

    @Override
    public Recharges getElementAt(int r) {
        return recharges.get(r);
    }
    
    class ListenerRechargerModel implements ListDataListener{
        RechargeState rechargeState;

        public ListenerRechargerModel(RechargeState rechargeState) {
            this.rechargeState = rechargeState;
        }

        @Override
        public void intervalAdded(ListDataEvent l) {
            Recharges addRecharge = rechargeModel.getElementAt(l.getIndex0());
            if(addRecharge.getState() == state ){
                int index = recharges.size();
                recharges.add(addRecharge);
                fireIntervalAdded(rechargeState, index, index);
            }
        }

        @Override
        public void intervalRemoved(ListDataEvent lde) {
            for(int i=lde.getIndex0(); i<=lde.getIndex1();i++ ){
                Recharges removedRecharge = rechargeModel.getElementAt(i);
                if(removedRecharge.getState() == state){
                    int index = recharges.indexOf(removedRecharge);
                    if(index != -1)
                    {
                        recharges.remove(index);
                        fireIntervalRemoved(rechargeState, index, index);
                    }
                    
                }
            }
        }

        @Override
        public void contentsChanged(ListDataEvent lde) {
            Recharges changRecharge = rechargeModel.getElementAt(lde.getIndex0());
            if(changRecharge.getState() == state){
                int index = recharges.size();
                recharges.add(changRecharge);
                fireIntervalAdded(rechargeState, index, index);
            }
            else{
                int index = recharges.indexOf(changRecharge);
                if(index != -1){
                    recharges.remove(index);
                    fireIntervalRemoved(rechargeState, index, index);
                }
            }
        
        }
        
    }

    public RechargeState(RechargeModel rechargeModel, int state) {
        recharges = new ArrayList<>();
        this.rechargeModel = rechargeModel;
        this.state = state;
        ListenerRechargerModel lrm = new ListenerRechargerModel(this);
        rechargeModel.addListDataListener(lrm);
    }
    
    
}
