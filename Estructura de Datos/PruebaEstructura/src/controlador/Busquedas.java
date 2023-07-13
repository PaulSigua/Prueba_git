
package controlador;

public class Busquedas {
    public int busquedaBinaria(int [] arreglo, int elemento){
        int bajo = 0;
        int alto =  arreglo.length -1;
        int posicion = -1;
        while(bajo <= alto){
            int centro = (bajo + alto)/2;
            if(arreglo[centro] == elemento){
                posicion = centro;
                break;
            }else if(elemento < arreglo[centro]){
                alto = centro;
            }else if(elemento > arreglo[centro]){
                bajo = centro +1;
            }
        }
        return posicion;
    }
    
    public int busquedaSecuencial(int arreglo[], int dato){
        int posicion = -1;
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i]== dato){
                return i;
            }
        }
        return posicion;
    }
}
