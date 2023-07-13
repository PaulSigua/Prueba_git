/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//Clase padre de tipo persona padre de user y dependent
package model;
/**
 *
 * @author josev
 */
//Clase padre de usuario y de trabajador
public class Person {
    private String name;

    public Person() {
    }
    
    //Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    //Métodos heredados
    @Override
    public String toString(){
        return name;
    }
}
