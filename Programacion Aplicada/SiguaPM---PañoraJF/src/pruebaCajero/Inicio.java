/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaCajero;

/**
 *
 * @author LENOVO
 */
public class Inicio {
    public static void main(String[] args) {
        Cajero c = new Cajero();
        Asignar a = new Asignar(c, 0);
        Atender at = new Atender(c, 0);
        
        a.start();
        at.start();
    }
}
