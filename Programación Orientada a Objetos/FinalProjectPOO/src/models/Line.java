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
//Clase principal
public class Line {
    
    //Atributos de la clase
    private String alternatives;
    private Double cost;

    //Constructor
    public Line() {
    }

    //Getters y setters 
    public String getAlternatives() {
        return alternatives;
    }

    public Double getCost() {
        return cost;
    }

    public void setAlternatives(String alternatives) {
        this.alternatives = alternatives.indent(3);
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
 
    //Método sobreescrito que nos devuelve una alternativa para realizar la recarga
    @Override
    public String toString() {
        return alternatives;
    }

}
