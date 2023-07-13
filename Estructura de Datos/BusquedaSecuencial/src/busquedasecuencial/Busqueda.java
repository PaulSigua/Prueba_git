/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busquedasecuencial;

/**
 *
 * @author UPS
 */
public class Busqueda {
    
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
