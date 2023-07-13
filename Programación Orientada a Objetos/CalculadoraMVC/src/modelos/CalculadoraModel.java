/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Alienware
 */
public class CalculadoraModel {
    private double op1;
    private double op2;
    private int operacion;
    private double resultado;
    private PropertyChangeSupport mPcs;

    public CalculadoraModel() {
        mPcs = new PropertyChangeSupport(this);
    }
       
    public void setOp1(double op1) {
        this.op1 = op1;
    }

    public void setOp2(double op2) {
        this.op2 = op2;
    }

    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }  

    public double getResultado() {
        return resultado;
    }
    
    public void calcular(){
        double viejoResultado = resultado;
        switch(operacion){
            case 0:
                resultado = op1 + op2;
                break;
            case 1:
                resultado = op1 - op2;
                break;
            case 2:
                resultado = op1 * op2;
                break;
            case 3:
                resultado = op1 / op2;
                break;
        }
        mPcs.firePropertyChange("resultado", viejoResultado, resultado);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener){
        mPcs.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener){
        mPcs.removePropertyChangeListener(listener);
    }
}
