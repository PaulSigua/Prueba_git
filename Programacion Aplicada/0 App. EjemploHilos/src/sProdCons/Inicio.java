/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sProdCons;

/**
 *
 * @author LENOVO
 */
public class Inicio {
    public static void main(String[] args) {
        
        Bodega b = new Bodega();
        Consume c = new Consume(b);
        Produce p = new Produce(b);
        
        c.start();
        p.start();
        
        System.out.println("Valor final del consumo " + b.getValor());
    }
}
