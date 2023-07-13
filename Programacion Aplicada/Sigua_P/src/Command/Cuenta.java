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
public class Cuenta {

    private int id;
    private double saldo;

    public Cuenta(int id, double saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public void retirar(double monto) {
        this.saldo = this.saldo - monto;
        System.out.println("[COMANDO RETIRAR] Cuenta: " + id + " Saldo: " + this.saldo);
    }

    public void depositar(double monto) {
        this.saldo = this.saldo + monto;
        System.out.println("[COMANDO DEPOSITAR] Cuenta: " + id + " Saldo: " + this.saldo);
    }
    
    public void transferir(Cuenta cuenta, double monto){
        this.saldo = this.saldo - monto;
        cuenta.saldo = cuenta.saldo + monto;
        System.out.println("[COMANDO TRANSFERIR] Cuenta: " + id + " Saldo " + this.saldo + " Cuenta: " + cuenta.id + " SALDO: " + cuenta.saldo);
    }
}
