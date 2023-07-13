/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//clase para los objetos de tipo ticket

package model;

/**
 *
 * @author josev
 */
public class Ticket {
    //Declaración de atributos de la clase
    private Dependent dependent = null;
    private String cubiculum;
    private String service;
    private String status;
    private String code;
    private User user;
    
    //Constructor
    public Ticket() {
    }
    
    //Getters y setters    
    public void setUser(User user) {
        this.user = user;
    }
    public String getCubiculum() {
        return cubiculum;
    }
    public void setCubiculum(String cubiculum) {
        this.cubiculum = cubiculum;
    }
    public void setDependent(Dependent dependent) {
        this.dependent = dependent;
    }
    public void setService(String service) {
        this.service = service;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public User getUser() {
        return user;
    }
    public Dependent getDependent() {
        return dependent;
    }
    public String getService() {
        return service;
    }
    public String getStatus() {
        return status;
    }
    public String getCode() {
        return code;
    }
    
    //Métodos heredados
   @Override
    public String toString(){
        return code+ " - " + service;
    } 
    
    
}
