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
public class ArrayList {

    Object[] lista;
    int i = 0;

    public ArrayList(int tam) {
        lista = new Object[tam];
    }
    
    public void add(Object valor){
        lista[i] = valor;
        i++;
    }
    
    public Object get(int pos){
        return lista[pos];
    }
}
