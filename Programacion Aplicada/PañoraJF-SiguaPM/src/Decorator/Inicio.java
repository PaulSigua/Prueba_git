/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import java.util.Scanner;

/**
 *
 * @author aplaza
 */
public class Inicio {

    public static void main(String args[]) {

        Scanner entrada = new Scanner(System.in);
        int opc;

        Empleado empleado = new Empleado("Jeison");

        ISueldo sueldo = new SueldoEmpleado();
        
        ISueldo extras = new ExtrasDecorator(sueldo);

        do {
            System.out.println("1. Mostrar el sueldo sin horas extras del cliente. ");
            System.out.println("2. Mostrar el saldo del cliente con horas extras. ");
            System.out.println("0. Salir");
            opc = entrada.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Ingrese las horas del cliente");
                    int hora = entrada.nextInt();
                    empleado.setHora(hora);

                    System.out.println("Las horas que trabajo el empleado " + empleado.getNombre() + " son " + empleado.getHora());
                    sueldo.actualizarHoras(empleado);
                    break;

                case 2:
                    System.out.println("Ingrese las horas del cliente");
                    double hora2 = entrada.nextInt();
                    empleado.setHora(hora2);

                    System.out.println("Ingrese las horas extras del cliente");
                    double horas = entrada.nextInt();
                    empleado.setExtras(horas);

                    System.out.println("Sueldo del empleado " + empleado.getNombre() + ", Sueldo: --> " + empleado.getHora()*1.5);
                    System.out.println("Las horas extras que trabajo el empleado " + empleado.getNombre() + " son " + empleado.getExtras());
                    extras.actualizarHoras(empleado);
                    break;
            }
        } while (opc != 0);

        
    }
    
}
