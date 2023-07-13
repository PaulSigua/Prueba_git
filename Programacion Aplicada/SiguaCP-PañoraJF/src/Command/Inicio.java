/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.Scanner;


/**
 *
 * @author LENOVO
 */
public class Inicio {
    public static void main(String[] args) {
        Contrato contrato = new Contrato("Mateo");
        DeterminarVacacionesImpl determinarV = new DeterminarVacacionesImpl(contrato, contrato.getMeses());
        Invoker invoker = new Invoker(); 
        Scanner entrada = new Scanner(System.in);
        int opc;

        System.out.println("          BINEVENID@          ");
        do {
            System.out.println("1. Determinar dias de vacacion");
            System.out.println("2. Determinar sueldo final");
            System.out.println("3. Realizar operaciones");
            System.out.println("0. Salir");
            System.out.println("Ingrese una opción: ");
            opc = entrada.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Ingrese la cantidad de años por meses: ");
                    int tiempo = entrada.nextInt();
                    determinarV  = new DeterminarVacacionesImpl(contrato, tiempo);
                    invoker.recibirOperacion(determinarV);
                    break;

                case 2:
                    System.out.println("Ingrese la cantidad de años por meses: ");
                    int tiempo2 = entrada.nextInt();
                    DeterminarSueldoImpl sueldofinal=new DeterminarSueldoImpl(contrato, tiempo2);
                    invoker.recibirOperacion(sueldofinal);
                    break;

                case 3:
                    System.out.println("Cliente: " + contrato.getNombre());
                    invoker.realizarOperaciones();
                    break;
            }
        } while (opc != 0);
    }
}
