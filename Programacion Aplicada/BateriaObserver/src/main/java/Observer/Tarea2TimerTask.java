/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Tarea2TimerTask extends TimerTask{
    int min = 0, hora = 0;
    VistaBateria vista;
    public Observador observador;
    public Subject sujeto;
    
    public Tarea2TimerTask(VistaBateria vista, Subject sujeto){
        this.vista = vista;
        this.sujeto = sujeto;
        this.sujeto.agregar(observador);
    }
    @Override
    public void run() {
        
        min--;
        if (min == 0 && hora <= 1) { 
            hora--;
        }if(hora > 100){ 
            
            System.out.println("El porcentaje no puede ser mayor a 100");
        }
    }
    
    public void actualizarTimer2(){
        observador.actualizar();
    }
}
