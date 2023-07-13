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
public class MetodosEstaticos {

    public static void calcularSueldoRegla1(ArrayList<? super Operario> lista) {
        for (Object c : lista) {
            if (c instanceof Persona) {
                System.out.println("Nombre: " + ((Persona) c).getNombre() + ", Cedula: " + ((Persona) c).getId() + ", Horas: " + ((Persona) c).getHoras() + ", Horas extras: " + ((Persona) c).getHorasExtras());
                ((Persona) c).calcularSalario();
            }
            
        }
    }

    public static void calcularSueldoRegla2(ArrayList<? extends Persona> lista) {
        for (Persona c : lista) {
            if (c instanceof Persona) {
                System.out.println("Nombre: " + c.getNombre() + ", Cedula: " + c.getId() + ", Horas: " + c.getHoras() + ", Horas extras: " + c.getHorasExtras());
                c.calcularSalario();
            }
            
        }
    }

    public static void calcularSueldoRegla3(ArrayList<? extends Jefe> lista) {
        for (Object c : lista) {
            if (c instanceof Jefe) {
                System.out.println("Nombre: " + ((Jefe) c).getNombre() + ", Cedula: " + ((Jefe) c).getId() + ", Horas: " + ((Jefe) c).getHoras() + ", Horas extras: " + ((Jefe) c).getHorasExtras());
                ((Jefe) c).calcularSalario();
            }
            if (c instanceof Operario) {
                ((Operario) c).calcularSalario();
            }
        }
    }
}
