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
public class Inicio {
    public static void main(String [] args){
        Cuenta cuenta1 = new Cuenta(1, 200);
        Cuenta cuenta2 = new Cuenta(2, 300);
        
        System.out.println("SALDO DE LA CUENTA 1: 200");
        System.out.println("SALDO DE LA CUENTA 2: 300");

                RetirarImpl opRetirar = new RetirarImpl(cuenta1, 100);
		Depositarlmpl opDepositar = new Depositarlmpl(cuenta1, 100);
                Transferirlmpl opTrans = new Transferirlmpl(cuenta1, cuenta2, 100);     
		//RetirarImpl opRetirar = new RetirarImpl(cuenta, 50);

		Invoker ivk = new Invoker();
                ivk.recibirOperacion(opRetirar);
		ivk.recibirOperacion(opDepositar);
                ivk.recibirOperacion(opTrans);

		ivk.realizarOperaciones();
                
    }
}
