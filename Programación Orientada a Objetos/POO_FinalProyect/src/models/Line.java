/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author LENOVO
 */
public class Line {
    private String alternatives;
    private Double cost;

    public Line() {
        
    }

    public String getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(String alternatives) {
        this.alternatives = alternatives;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return alternatives;
    }
    
}
