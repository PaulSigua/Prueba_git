/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.DefaultListaOrdenes;
import vista.VistaOrdenes;
import modelo.DefaultListaClientes;
/**
 *
 * @author LENOVO
 */
public class Principal {
    public static void main(String [] args){
        DefaultListaOrdenes lo = new DefaultListaOrdenes();
        //VistaCliente v = new VistaOrdenes();
        VistaOrdenes vistaOrdenes = new VistaOrdenes();
        DefaultListaClientes lc = new DefaultListaClientes();
        ControladorOrdenes co = new ControladorOrdenes(lo, lc, vistaOrdenes);
        ControladorCliente cc = new ControladorCliente(lc, vistaOrdenes);
    }

}
