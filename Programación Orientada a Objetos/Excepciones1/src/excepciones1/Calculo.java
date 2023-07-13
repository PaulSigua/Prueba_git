/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones1;
import java.lang.ArithmeticException;
import static java.lang.Double.NaN;

/**
 *
 * @author Jeison
 */
public class Calculo {
    double op1,op2;

    public Calculo() {
        op1=NaN;
        op2=NaN;
    }

    public void setOp1(double op1) {
        this.op1 = op1;
    }

    public void setOp2(double op2) {
        this.op2 = op2;
    }
    public double calcular()throws ArithmeticException{
        if (!Double.isNaN(op1)&&!Double.isNaN(op2)){ 
            return op1 + op2;
        }
        else {
            throw new OpNoInicializadosException("Los operadores no han sido inicializados");
        }
    }
    
}
