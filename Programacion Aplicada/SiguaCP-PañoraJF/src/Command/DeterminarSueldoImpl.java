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
public class DeterminarSueldoImpl implements IOperacion{

    private Contrato contrato;
    private int sueldo;

    public DeterminarSueldoImpl(Contrato contrato, int sueldo) {
        this.contrato = contrato;
        this.sueldo = sueldo;
    }
    
    @Override
    public void invocar() {
        this.contrato.determinarSueldo(this.sueldo);
    }
    
}
