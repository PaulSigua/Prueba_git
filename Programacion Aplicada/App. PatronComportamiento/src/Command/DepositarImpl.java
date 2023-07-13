/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

/**
 *
 * @author aplaza
 */
public class DepositarImpl implements IOperacion {

	private Cuenta cuenta;
	private double monto;

	public DepositarImpl(Cuenta cuenta, double monto) {
		this.cuenta = cuenta;
		this.monto = monto;
	}

	@Override
	public void execute() {
		this.cuenta.depositar(this.monto);
	}

}
