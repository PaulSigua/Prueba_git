/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodoshell;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MetodoShell {

    public static void main(String[] args) {
        int aux;
        boolean cambios;
        Scanner teclado = new Scanner(System.in);
        List<Integer> lista = new ArrayList<>();
        int opc= 0;
        do{
            System.out.println("1. Ingresar Numero");
            System.out.println("2. Ordenar Shell");
            System.out.println("0. Salir");
            opc = teclado.nextInt();
            switch(opc){
                case 1:
                    System.out.println("Ingrese un numero");
                    lista.add(teclado.nextInt());
                    break;
                case 2:
                    for(int k = lista.size() /2; k!=0; k /=2){
                        cambios = true;
                        while(cambios){
                            cambios= false;
                            for(int i=k; i<lista.size(); i++){
                                if(lista.get(i-k)> lista.get(i)){
                                    aux = lista.get(i);
                                    lista.set(i, lista.get(i-k));
                                    lista.set(i-k, aux);
                                    cambios = true;
                                }
                            }
                        }
                    }
                    for (int j : lista) {
                        System.out.print(j + " | ");
                    }
                    break;
                }
        }while(opc != 0);
    } 
}
