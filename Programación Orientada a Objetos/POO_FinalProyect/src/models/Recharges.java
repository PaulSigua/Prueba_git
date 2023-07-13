/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Recharges {
    private Client client;
    private ArrayList<RechargeModel> recharges;
    private ArrayList<Combo> combos;
    int state;

    public Recharges(Client client, int num) {
        this.client = client;
        recharges = new ArrayList<>();
        combos = new ArrayList<>();
        this.state = state;
    }
    
    public void addRecharges(Recharges recharges){
        recharges.addRecharges(recharges);
    }
    
    public void addCombo(Combo combo){
        combos.add(combo);
    }
    
     public double getCost(){
        double cost = 0;
        for (RechargeModel recharge: recharges){
            cost = cost + recharge.getSize();
        }
        for (Combo combo : combos){
            cost = cost + combo.getCost();
        }
        return cost;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    @Override
    public String toString() {
        String infoRecharges = "";
        for(RechargeModel recharge: recharges){
            infoRecharges += recharge.toString() + "; ";
        }
        
        String infoCombos = "";
        for(Combo combo: combos){
            infoCombos += combo.toString() + "; ";
        }
        return infoRecharges + "; " + infoCombos;
    }

    public Client getClient() {
        return client;
    }

    public ArrayList<RechargeModel> getRecharges() {
        return recharges;
    }

    public ArrayList<Combo> getCombos() {
        return combos;
    }
    
}
