/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generica;

/**
 *
 * @author LENOVO
 */
public class Operario extends Persona{
    
    public Operario(String nombre, String id, double horas, double horasExtras) {
        super(nombre, id, horas, horasExtras);
    }
    
    @Override
    public void calcularSalario(){
        if (getHoras() >=1) {
            System.out.println("Salario: " + (getHoras() * 1.5));
        }
        if (getHorasExtras()==1) {
            System.out.println("Salario con horas extras: " + (((getHoras()*1.5) + (getHorasExtras()*1.5))));
        }else{
            System.out.println("Salario con horas extras es: "+(((getHoras()*1.5) + (getHorasExtras()*1.00))));
        }
    }
}
