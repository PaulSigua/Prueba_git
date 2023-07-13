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
public class RechargeClient {
    private Combo combo;
    private ArrayList<Combo> combos;

    public RechargeClient() {
        combos = new ArrayList<>();
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }

    public void addCombo(Combo combo){
        combos.add(combo);
    }
    
    public double getCost(){
        double cost = 0;
        for(Combo combo :  combos){
            cost = cost + combo.getCost();
        }
        return combo.getCost() + cost;
    }

    @Override
    public String toString() {
        return "Recarga del cliente: " + combos.get(0).getAlternatives() + " "
                + combos.size() + " combos";
    }
    
    
}
