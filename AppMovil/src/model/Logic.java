
package model;

/**
 *
 * @author mateo
 */
public class Logic {
    RechargeDaoImpl rechargeDaoImpl = new RechargeDaoImpl();
    
    public boolean addRechargeLineOne(int codId, String name, int idClient, int cell, int age){
        return rechargeDaoImpl.registerRechargeLineOne(codId, name, idClient, cell, age);
    }
    
    public boolean addRechargeLineTwo(int codId, String name, int idClient, int cell, int age){
        return rechargeDaoImpl.registerRechargeLineTwo(codId, name, idClient, cell, age);
    }
    
    public boolean addRechargeLineThree(int codId, String name, int idClient, int cell, int age){
        return rechargeDaoImpl.registerRechargeLineThree(codId, name, idClient, cell, age);
    }
    
    public boolean addRechargeLineFour(int codId, String name, int idClient, int cell, int age){
        return rechargeDaoImpl.registerRechargeLineFour(codId, name, idClient, cell, age);
    }
}
