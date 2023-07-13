/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.util.List;
import modelo.logica.Logica;
import vista.VentanaMenu;

/**
 *
 * @author aplaza
 */
public class cEjemplar 
{
    private Logica miLogica;
    private VentanaMenu ventanaMenu;

    public Logica getMilogica() {
        return miLogica;
    }

    public void setMilogica(Logica miLogica) {
        this.miLogica = miLogica;
    }

    public VentanaMenu getVentanaMenu() {
        return ventanaMenu;
    }

    public void setVentanaMenu(VentanaMenu ventanaMenu) {
        this.ventanaMenu = ventanaMenu;
    }
    
    public void realizarPrueba(){
        miLogica.realizarPrueba();
    }
    
    public ResultSet buscarRevista(int codigo){
        return miLogica.buscarRevista(codigo);
    }

    public boolean agregarEjemplar(int codEjemplar, String fecha, int numPag, int numVentas, int codRev) {
        return miLogica.agregarRevista(codEjemplar, fecha, numPag, numVentas, codRev);
    }
    
}
