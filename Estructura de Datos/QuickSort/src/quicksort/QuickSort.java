/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quicksort;

/**
 *
 * @author UPS
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arreglo = {15,12,9,10,7,20,5};
        quicksort(arreglo, 0, arreglo.length-1);
        for (int i : arreglo) {
            System.out.print(i+" | ");
        }
    }
    
    public static void quicksort(int[] arreglo, int izq, int der){
        int i, j, pivote;
        if(izq>der){
            return;
        }
        i=izq;
        j=der;
        pivote = arreglo[izq];
        while(i<j){
            while(pivote<=arreglo[j] && i<j){
                j--;
            }
            while(pivote>=arreglo[i] && i<j){
                i++;
            }
            if(i<j){
                int aux = arreglo[j];
                arreglo[j] = arreglo[i];
                arreglo[i] = aux;
            }
        }
        arreglo[izq] = arreglo[i];
        arreglo[i] = pivote;
        quicksort(arreglo, izq, j-1);
        quicksort(arreglo, j+1, der);
    }
}
