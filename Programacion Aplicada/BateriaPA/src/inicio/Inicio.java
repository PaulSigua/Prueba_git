/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicio;
import observer.Bateria;
import observer.Subject;
import vista.Metodos;
import vista.VistaBateria;
/**
 *
 * @author LENOVO
 */
public class Inicio {
    public static void main(String[] args) {
        Metodos vistaB = new VistaBateria();
        Bateria b = new Bateria();
        Controlador c = new Controlador(vistaB, b);
        
        vistaB.setVisible(true);
    }
}
