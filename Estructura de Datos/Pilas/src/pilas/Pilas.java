/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pilas;

import java.util.Stack;

/**
 *
 * @author UPS
 */
public class Pilas {

    public static void main(String[] args) {
        Stack<Integer> pila = new Stack();
        System.out.println(pila.empty());
        pila.push(5);
        pila.push(10);
        pila.push(13);
        /*System.out.println(pila.peek());
        System.out.println(pila.peek());
        System.out.println(pila.size());
        pila.forEach(e -> System.out.println(e));
*/
        System.out.println(pila.search(5));
    }
    
}
