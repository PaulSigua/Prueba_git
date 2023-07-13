/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busquedabinaria;

/**
 *
 * @author UPS
 */
public class Binaria {
    
    public int busqueda(int [] arreglo, int elemento){
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
    
}
