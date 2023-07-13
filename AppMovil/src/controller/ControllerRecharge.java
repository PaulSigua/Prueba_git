
package controller;

import model.Logic;
import view.WindowLineONE;

/**
 *
 * @author mateo
 */
public class ControllerRecharge {
    private Logic myLogic = new Logic();
    private WindowLineONE windowOne;
    public Logic getMyLogic(){
        return myLogic;
    }
    
    public WindowLineONE getWindowOne(){
        return windowOne;
    }
    
    public boolean addRechargeLineOne(int codId, String name, int idClient, int cell, int age){
        return myLogic.addRechargeLineOne(codId, name, idClient, cell, age);
    }
    
    public boolean addRechargeLineTwo(int codId, String name, int idClient, int cell, int age){
        return myLogic.addRechargeLineTwo(codId, name, idClient, cell, age);
    }
    
    public boolean addRechargeLineThree(int codId, String name, int idClient, int cell, int age){
        return myLogic.addRechargeLineThree(codId, name, idClient, cell, age);
    }
    
    public boolean addRechargeLineFour(int codId, String name, int idClient, int cell, int age){
        return myLogic.addRechargeLineFour(codId, name, idClient, cell, age);
    }
}
