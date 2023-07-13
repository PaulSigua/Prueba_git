/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quicksort;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author UPS
 */
public class OrdenamientoDefecto {
    public static void main(String[] args){
        List<Integer> lista = new ArrayList();
        for (int i = 0; i < 100; i++) {
            lista.add((int)(Math.random()*1000));
        }
        lista.stream().sorted().forEach(e -> System.out.println(e));
        
    }
    
}
