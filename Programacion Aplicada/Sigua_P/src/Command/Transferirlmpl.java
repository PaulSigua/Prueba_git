/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

/**
 *
 * @author LENOVO
 */
public class Transferirlmpl implements IOperacion{
    private Cuenta cuenta1;
    private Cuenta cuenta2;
    private double monto;

    public Transferirlmpl(Cuenta cuenta1, Cuenta cuenta2, double monto) {
        this.cuenta1 = cuenta1;
        this.cuenta2 = cuenta2;
        this.monto = monto;
    }

    @Override
    public void execute() {
        this.cuenta1.transferir(cuenta2, monto);
    }
    
    
    
}
