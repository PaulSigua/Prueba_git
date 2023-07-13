/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Logica;
import vista.Ventana;

/**
 *
 * @author LENOVO
 */
public class ControladorBloque {
    private Logica miLogica = new Logica();
    private Ventana v;
    
    public Logica getMilogica(){
        return miLogica;
    }
    
    public Ventana getVentana(){
        return v;
    }
    public boolean agregarBloque(int codBloque, String nombre, int numDepa){
        return miLogica.agregarBloque(codBloque, nombre, numDepa);
    }
}
