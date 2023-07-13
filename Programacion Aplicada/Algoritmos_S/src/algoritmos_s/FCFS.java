/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmos_s;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Usuario
 */
public class FCFS {

    private Vector referencias;
    private Vector marcos;
    private String[][] registro;
    private int numMarcos;
    private int cont2;
    private int cont;
    private int fallos;

    public FCFS(Vector referencias, int numMarcos) {
        this.referencias = referencias;
        this.numMarcos = numMarcos;
        cont2 = 0;
        fallos = 0;
        marcos = new Vector(numMarcos);
        cont = 0;
        for (int i = 0; i < numMarcos; i++)//Colocar todos lo valores como nulos
        {
            marcos.addElement(" ");
        }
        registro = new String[numMarcos][0];
    }

    public void ejecutar() {
        System.out.println("ALGORITMO FCFS");
        System.out.println(referencias);
        System.out.println("Marcos: " + numMarcos);
        System.out.println(marcos);
        for (int i = 0; i < referencias.size(); i++) {
            for (int j = 0; j < numMarcos; j++) {
                if (marcos.get(j) == " ")//El marco esta vacio
                {
                    marcos.set(j, referencias.get(i));
                    registrar();
                    break;
                } else if (marcos.get(j) == referencias.get(i))//La pagina si esta cargada
                {
                    break;
                } else if ((j + 1) == numMarcos)//La pagina no esta cargada
                {
                    if (cont == numMarcos)//Si el contador llega al final del marco se regresa desde el inicio
                    {
                        cont = 0;
                    }
                    marcos.set(cont, referencias.get(i));//Se remplaza en el orden que llegan
                    registrar();
                    cont++;
                    break;
                }
            }
        }
        imprimir();
    }

    public void registrar() {
        int columnas = registro[0].length + 1;
        String[][] registroAux = registro.clone();
        registro = new String[numMarcos][columnas];
        if (registroAux[0].length != 0) {
            for (int i = 0; i < numMarcos; i++) {
                for (int j = 0; j < registroAux[0].length; j++) {
                    registro[i][j] = registroAux[i][j];
                }
            }
        }
        for (int j = cont2; j < columnas; j++)//Hacer el registro de los marcos
        {
            for (int i = 0; i < numMarcos; i++) {
                registro[i][j] = marcos.get(i) + "" ;
            }
        }
        cont2++;
        fallos++;
    }

    public void imprimir() {
        int columnas = registro[0].length;
        for (int i = 0; i < numMarcos; i++)//Imprimir el regristro de los marcos
        {
            for (int j = 0; j < columnas; j++) {
                System.out.print(registro[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("\n" + "Fallos: " + fallos + "\n");
    }

}
