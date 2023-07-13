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

    public VentanaMenu getVentanaPersona() {
        return ventanaMenu;
    }

    public void setVentanaPersona(VentanaMenu ventanaPersona) {
        this.ventanaMenu = ventanaPersona;
    }
    
    public void conectar()
    {
        miLogica.conectar();
    }
    
    public boolean registrarDatos(int codigo, String fecha, int numPaginas, int numVentas)
    {
        return miLogica.ingresar(codigo, fecha, numPaginas, numVentas);
    }
    
    public ResultSet listar()
    {
        return miLogica.listar();
        
        //List<mPersona> listaPersonas=miLogica.listarPersonas();
       // VentanaMenu.imprimirListado(listaPersonas);
    }
}
