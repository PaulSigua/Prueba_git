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
public class Recharge {
    //Creación de atributos
    private Combo combo;
    private ArrayList<Line> lines;

    //Constructor
    public Recharge() {
        lines = new ArrayList<>();
    }
    
    //Método para establecer un cliente
    public void setClient(Combo combo){
        this.combo = combo;
    }
    
    //Método para añadir una recarga
    public void addRechargeClient(Line rechargeclient){
        lines.add(rechargeclient);
    }
    
    //Método para obtener el costo
    public double getCost(){
        double cost = 0;
        for(Line line : lines){
            cost = cost + line.getCost();
        } 
        return combo.getCost() + cost;
    }

    //Método sobreescrito
    @Override
    public String toString() {
        return "Recarga: " + lines.get(0).getAlternatives() + lines.size() + " del cliente: " + combo.getAlternatives();
    }
}
