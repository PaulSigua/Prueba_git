/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comodin1;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Inicio {

    public static void main(String[] args) {
        Admin p1 = new Admin("Wendy", "Sigua");
        Admin p2 = new Admin("Ana", "Plaza");

        ArrayList<Admin> lista = new ArrayList<>();
        lista.add(p1);
        lista.add(p2);

        listar(lista);

    }

    public static void listar(ArrayList<? extends Persona> lista) {
        for (Object p : lista) {
            if (p instanceof Persona) {
                System.out.println(((Persona)p).toString());
            } 
            else if (p instanceof Docente) {
                System.out.println(((Docente)p).toString());
            }
            else if (p instanceof Estudiante) {
                System.out.println(((Estudiante)p).toString());
            }
            else if (p instanceof Admin) {
                System.out.println("No fue posible imprimir al Administrador");
            } 
            else {
                System.out.println("Ocurrio un error");
            }break;
        }
    }
}
