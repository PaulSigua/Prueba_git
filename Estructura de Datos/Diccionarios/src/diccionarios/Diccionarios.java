/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package diccionarios;

import controlador.ControladorJugador;
import java.util.HashMap;
import vista.VistaJugador;

/**
 *
 * @author UPS
 */
public class Diccionarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        HashMap<Integer, String> hashMap = new HashMap();
        hashMap.put(1, "Diego");
        hashMap.put(2,  "Juan");
        hashMap.put(10, "Maria");
        hashMap.put(20, "Luisa");
        hashMap.put(15, "Gabriela");
        hashMap.put(5, "Fernando");
        hashMap.forEach((k,v)-> System.out.println(k + " -> " + v));
        System.out.println("vacio: " + hashMap.isEmpty());
        System.out.println("tamaño: " + hashMap.size());
        System.out.println("elemento (2) " + hashMap.get(2));
        System.out.println("eliminar (10)" + hashMap.remove(10));
        System.out.println("existe  (15)" + hashMap.containsKey(15));
        System.out.println("existe valor (Diego)" + hashMap.containsValue("Diego"));
        System.out.println("remplzar (20)" + hashMap.replace(20, "Luis"));
        System.out.println("Solo claves ");
        hashMap.keySet().forEach(k-> System.out.println(k));
        System.out.println("Solo valores ");
        hashMap.values().forEach(v-> System.out.println(v));
        System.out.println("eliminar todo" );
        hashMap.clear();
*/
        ControladorJugador controladorJugador = new ControladorJugador();
        VistaJugador vistaJugador = new VistaJugador(controladorJugador);
        vistaJugador.menu();
    }
    
}
