/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicio;

import observer.Bateria;
import vista.Metodos;

/**
 *
 * @author LENOVO
 */
public class Controlador {

    private Metodos metodos;
    private Bateria bateria;
    
    public Controlador(Metodos metodos, Bateria bateria) {
        this.metodos = metodos;
        this.bateria = bateria;
        
        ConectarButton cb = new ConectarButton(metodos, bateria);
        metodos.conectarBateria(cb);
    }
}
