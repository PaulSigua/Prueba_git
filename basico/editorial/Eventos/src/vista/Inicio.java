/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.cEjemplar;
import modelo.logica.Logica;

/**
 *
 * @author aplaza
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        VentanaMenu v=new VentanaMenu();
        cEjemplar controlEjemplar=new cEjemplar();
        Logica miLogica=new Logica();
            
        //Se hacen las relaciones entre las clases
        v.panelEjemplar.setControlador(controlEjemplar);
        
        //Se tienen las relaciones con el controlador
        controlEjemplar.setMilogica(miLogica);
        controlEjemplar.setVentanaPersona(v);
        
        v.setVisible(true);

    }
    
}
