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
        
        cEjemplar controladorEjemplar = new cEjemplar();
        v.panelEjemplar.setControladorEjemplar(controladorEjemplar);
        
        Logica miLogica = new Logica();
        
        controladorEjemplar.setMilogica(miLogica);
        controladorEjemplar.setVentanaMenu(v);
        
        
        v.setVisible(true);
    }
    
}
