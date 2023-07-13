/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package command;

import java.util.Scanner;

/**
 *
 * @author Jeiso
 */
public class Command {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Persona p=new Persona("as");
        
        //SueldoFinalImpl s=new SueldoFinalImpl(p, 34);
        //SueldoFinalImpl f=new SueldoFinalImpl(p, 34);
        //DiasVacionesImpl m=new DiasVacionesImpl(p, 1);
        //Invoker ivk=new Invoker();
        ////DiasVacionesImpl c=new DiasVacionesImpl(p, 34);
        //ivk.recibirOperacion(m);
        //ivk.recibirOperacion(c);
        //ivk.recibirOperacion(s);
        //ivk.recibirOperacion(f);
        //ivk.realizarOperaciones();
        Persona p=new Persona("");
        DiasVacionesImpl diasVacaiones=new DiasVacionesImpl(p, 0);
        SueldoFinalImpl sueldoFinal=new SueldoFinalImpl(p, 0);
        Scanner teclado=new Scanner(System.in);
        System.out.println("bienvenidos");
        int opc;
        do{
            System.out.println("1. Determinar dias de vacacion");
            System.out.println("2. Determinar sueldo final");
            System.out.println("3. Realizar operaciones");
            System.out.println("0. Salir");
            System.out.println("Ingrese una opción: ");
            opc=teclado.nextInt();
            switch(opc){
                case 1:
                    System.out.println("Ingrese su nombre");
                    String nombre=teclado.next();
                    System.out.println("Ingrese la cantidad de años en meses");
                    int meses=teclado.nextInt();
                    p=new Persona(nombre);
                    diasVacaiones=new DiasVacionesImpl(p, meses);
                    break;
                case 2:
                    System.out.println("Ingrese su nombre");
                    String nombreT=teclado.next();
                    System.out.println("Ingrese la cantidad de años en meses");
                    int mesesT=teclado.nextInt();
                    p=new Persona(nombreT);
                    sueldoFinal=new SueldoFinalImpl(p, mesesT);
                    break;
                case 3:
                    System.out.println("Cliente "+p.getNombre());
                    Invoker i=new Invoker();
                    i.recibirOperacion(diasVacaiones);
                    i.recibirOperacion(sueldoFinal);
                    i.realizarOperaciones();
                    break;
            }
        }while (opc != 0);
    }
    
}
