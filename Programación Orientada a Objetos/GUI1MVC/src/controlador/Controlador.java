/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import vista.VentanaPrincipal;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author UPS
 */
public class Controlador {
    VentanaPrincipal v;
    public Controlador(VentanaPrincipal v){
        this.v = v;
        this.v.setVisible(true);
        this.v.addConvertirButtonActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    handlerConvertir(ae);
                }               
            }
        );
    }
    
    private void handlerConvertir(ActionEvent ae){
        v.setFahrenheit(
                (int)(Double.parseDouble(v.getCelsius()) * 1.8 + 32)
        );
    }
}
