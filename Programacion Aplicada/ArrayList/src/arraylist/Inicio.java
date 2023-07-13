/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

/**
 *
 * @author LENOVO
 */
public class Inicio {
    public static void main(String[] args){
        ArrayList lista = new ArrayList(3);
        
        lista.add(45);
        lista.add(34);
        lista.add("tarea");
        
        int valor = (int) lista.get(1);
        System.out.println(valor);
    }
}
