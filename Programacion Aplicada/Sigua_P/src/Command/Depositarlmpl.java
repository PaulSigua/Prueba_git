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
public class Depositarlmpl implements IOperacion {

    private Cuenta cuenta1;
    private Cuenta cuenta2;
    private double monto;

    public Depositarlmpl(Cuenta cuenta1, double monto) {
        this.cuenta1 = cuenta1;
        this.monto = monto;
    }

    @Override
    public void execute() {
        this.cuenta1.depositar(this.monto);
    }
    
    public int getdato(int dato){
        dato = 4;
        return dato;
    }
    
}
