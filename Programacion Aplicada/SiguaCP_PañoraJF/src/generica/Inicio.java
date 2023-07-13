/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generica;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Inicio {

    public static void main(String[] args) {
        Persona p1 = new Persona("Wendy", "0106764848", 2, 1);
        Operario o1 = new Operario("Brayan", "0105468912", 2, 2);
        Administrador a1 = new Administrador("David", "0102438157", 2, 2);
        Jefe f1 = new Jefe("Andres", "0106764852", 3, 1);

        MetodosEstaticos mE = new MetodosEstaticos();

        ArrayList<Administrador> listaA = new ArrayList<>();
        ArrayList<Jefe> listaJ = new ArrayList<>();
        ArrayList<Persona> listaP = new ArrayList<>();
        ArrayList<Operario> listaO = new ArrayList<>();

        listaA.add(a1);
        listaJ.add(f1);
        listaP.add(p1);
        listaO.add(o1);

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Persona y Operario");

        mE.calcularSueldoRegla1(listaP);
        mE.calcularSueldoRegla1(listaO);
        try {
//            mE.calcularSueldoRegla1(listaA);
//            mE.calcularSueldoRegla1(listaJ);
        } catch (RuntimeException ex) {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Ocurrio un error al imprimir una lista que no es Persona u Operario");
        }
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("Persona y sus hijos");

        mE.calcularSueldoRegla2(listaP);
        mE.calcularSueldoRegla2(listaO);
        mE.calcularSueldoRegla2(listaA);
        try {
//            mE.calcularSueldoRegla2(listaJ);
        } catch (RuntimeException ex) {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Ocurrio un error al imprimir una lista que no es Persona o sus hijos");
        }
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("Jefe");

        mE.calcularSueldoRegla3(listaJ);
        try {
//            mE.calcularSueldoRegla3(listaP);
//            mE.calcularSueldoRegla3(listaO);
//            mE.calcularSueldoRegla3(listaA);
        } catch (RuntimeException ex) {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Ocurrio un error al imprimir una lista que no pertenece a Jefe");
        }
        System.out.println("-------------------------------------------------------------------------------");
    
    }
}
