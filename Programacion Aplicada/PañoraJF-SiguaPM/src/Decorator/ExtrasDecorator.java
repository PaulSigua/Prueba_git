/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

/**
 *
 * @author LENOVO
 */
public class ExtrasDecorator extends SueldoDecorador {

    public ExtrasDecorator(ISueldo sueldo) {
        super(sueldo);
    }

    double extras = 2.0;
    double extras2 = 1.5;
    @Override
    public void actualizarHoras(Empleado empleado) {
        if (empleado.getExtras() == 2) {
            System.out.println("Sueldo con horas extras: " + (empleado.getHora()*extras2 + empleado.getExtras()));
        }else if(empleado.getExtras() == 1){
            System.out.println("Sueldo con horas extras: " + (empleado.getHora()*extras2));
        }
    }

}
