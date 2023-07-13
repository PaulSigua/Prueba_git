
package controlador;

public class Ordenamientos {
    public void ordenamientoQuickSort(int[] placa, int izq, int der){
        int i, j, pivote;
        if(izq>der){
            return;
        }
        i=izq;
        j=der;
        pivote = placa[izq];
        while(i<j){
            while(pivote<=placa[j] && i<j){
                j--;
            }
            while(pivote>=placa[i] && i<j){
                i++;
            }
            if(i<j){
                int aux = placa[j];
                placa[j] = placa[i];
                placa[i] = aux;
            }
        }
        placa[izq] = placa[i];
        placa[i] = pivote;
        ordenamientoQuickSort(placa, izq, j-1);
        ordenamientoQuickSort(placa, j+1, der);
    }
}
