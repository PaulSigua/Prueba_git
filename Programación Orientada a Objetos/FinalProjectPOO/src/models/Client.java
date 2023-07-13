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
//Método para los clientes
public class Client {
    private String number;
    private String id;

    //Constructor de la clase
    public Client(String number, String id) {
        this.number = number;
        this.id = id;
    }

    //Getters y setters de los atributos
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }    

    @Override
    public String toString() {
        return "Cliente del numero:" + id + " y cedula: " + number + '}';
    }
    
}
