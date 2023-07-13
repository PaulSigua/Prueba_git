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
public class DeterminarVacacionesImpl implements IOperacion{

    public Contrato contrato;
    public int meses;

    public DeterminarVacacionesImpl(Contrato contrato, int meses) {
        this.contrato = contrato;
        this.meses = meses;
    }
    
    @Override
    public void invocar() {
        this.contrato.determinarVacaciones(this.meses);
    }
    
}
