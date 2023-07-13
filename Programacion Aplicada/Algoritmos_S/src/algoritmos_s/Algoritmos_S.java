/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmos_s;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Usuario
 */
public class Algoritmos_S {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner scanner=new Scanner(System.in);
        Vector referencias=new Vector(20);
        FCFS fcfs;
        Optimo optimo;
        LRU lru;
        System.out.println("Algoritmos"+"\n"+"Ingrese el numero de referencias");
        //int numRef=scanner.nextInt();//Ingreso del numero de referencias
        int numRef=20;//->Borrar esto
        /*for(int i=0;i<numRef;i++)//Buqule para ingresar cada una de las referencias
        {
            System.out.println("Ingrese la referencia "+(i+1));
            int ref=scanner.nextInt();
            referencias.add(ref);
        }*/
        referencias.addElement(7);//->Borrar esto
        referencias.addElement(0);//->Borrar esto
        referencias.addElement(1);//->Borrar esto
        referencias.addElement(2);//->Borrar esto
        referencias.addElement(0);//->Borrar esto
        referencias.addElement(3);//->Borrar esto
        referencias.addElement(0);//->Borrar esto
        referencias.addElement(4);//->Borrar esto
        referencias.addElement(2);//->Borrar esto
        referencias.addElement(3);//->Borrar esto
        referencias.addElement(0);//->Borrar esto
        referencias.addElement(3);//->Borrar esto
        referencias.addElement(2);//->Borrar esto
        referencias.addElement(1);//->Borrar esto
        referencias.addElement(2);//->Borrar esto
        referencias.addElement(0);//->Borrar esto
        referencias.addElement(1);//->Borrar esto
        referencias.addElement(7);//->Borrar esto
        referencias.addElement(0);//->Borrar esto
        referencias.addElement(1);//->Borrar esto
        
        System.out.println("Ingrese el numero de marcos");
        //int numMarcos=scanner.nextInt();//Ingreso de la cantidad de marcos
        int numMarcos=3;//->Borrar esto
        fcfs=new FCFS(referencias,numMarcos);
        optimo=new Optimo(referencias,numMarcos);
        lru=new LRU(referencias,numMarcos);
        fcfs.ejecutar();
        optimo.ejecutar();
        lru.ejecutar();
    }
    
}
