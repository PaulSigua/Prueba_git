/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Objeto de tipo usuario

package model;

/**
 *
 * @author josev
 */
public class User  {
    
    //Atributos correspondientes a la clase
    private String name;
    private String id;
    private double money;

    //Constructores de la clase  
    public User(String name, String id, double money) {
        this.name = name;
        this.id = id;
        this.money = money;
    }
    public User(String id){
        this.id = id;
    }
    public User() {    
    }
        
    //Getters y setters de los atributos
    public void setMoney(double money) {
        this.money = money;
    }
    public void setName(String name){
        this.name = name;
    }    
    public void setId(String id) {
        this.id = id;
    }   
    public String getName() {
        return name;
    }       
    public double getMoney() {
        return money;
    }
    public String getId() {
        return id;
    }
}
