/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;
import observer.Bateria;
import vista.Metodos;

/**
 *
 * @author LENOVO
 */
public class ConectarButton implements ActionListener {

    Metodos metodos;
    Bateria bateria;
    Timer timer = new Timer();

    TimerTask tarea = new TimerTask() {
        @Override
        public void run() {
            
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        String texto = metodos.getPorcentajeTextField();
        if (texto.indexOf(100) <= 100) {
            metodos.setPorcentajeTextField(Integer.parseInt(texto));
            bateria.getPorcentaje();
            bateria.actualizar();
        }else{
            texto = "No admitido";
            metodos.setPorcentajeTextField(Integer.parseInt(texto));
        }
    }

    public ConectarButton(Metodos metodos, Bateria bateria) {
        this.metodos = metodos;
        this.bateria = bateria;
    }
}
