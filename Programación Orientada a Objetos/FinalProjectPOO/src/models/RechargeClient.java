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
    //Creación de los atributos y listas
    private Client client;
    private ArrayList<Recharge> recharges;
    private ArrayList<Combo> combos;
    int num;

    //Constructor e inicialización de los atributos/listas
    public RechargeClient(Client client, int num) {
        this.client = client;
        recharges = new ArrayList<>();
        combos = new ArrayList<>();
        this.num = num;
    }

    //Métodos para añadir una nueva recarga y un combo
    public void addRecharge(Recharge recharge){
        recharges.add(recharge);
    }
    
    public void addCombo(Combo combo){
        combos.add(combo);
    }
    
    //Getters y setters
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    //Método para obtener el costo 
    public double getCost(){
        double cost = 0;
        for(Recharge recharge : recharges){
            cost = cost + recharge.getCost();
        }
        for(Combo combo : combos){
            cost = cost + combo.getCost();
        }
        return cost;
    }
    
    //Método sobreescrito de las recargas y combos
    @Override
    public String toString() {
        String infoRecharges = "";
        for(Recharge recharge: recharges){
            infoRecharges += recharges.toString();
        }
        String infoCombos = "";
        for(Combo combos : combos){
            infoCombos += combos.toString();
        }
        return infoRecharges + " y su combo elegido es: " + infoCombos;
    }
}
