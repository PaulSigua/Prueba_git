/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodoburbuja;

/**
 *
 * @author UPS
 */
public class MetodoBurbuja {

    public static void main(String[] args) {
        int[] vector = {15,12,7,8};
        for(int i =0 ; i<vector.length-1; i++){
            for(int j = i+1; j < vector.length; j++){
                if(vector [i] < vector[j]){
                    int aux = vector[i];
                    vector[i] = vector[j];
                    vector[j] = aux;
                }
            }
        }
        for(int k = 0; k<vector.length; k++){
            System.out.print(vector[k] + " ");
        }
    }
    
}
