/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//Clase del objeto de tipo dependiente

package model;

/**
 *
 * @author josev
 */
public class Dependent extends Person {
    
    //Creación de los atributos de la clase
    private int numCabin;
    private boolean status;
    private int grade;
    
    //Constructor
    public Dependent(){                
    }

    //Distintos métodos a utilizar (getters y setters)
    public void setNumCabin(int numCabin) {
        this.numCabin = numCabin;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getNumCabin() {
        return numCabin;
    }

    public boolean isStatus() {
        return status;
    }

    public int getGrade() {
        return grade;
    }

    
    
    
}
