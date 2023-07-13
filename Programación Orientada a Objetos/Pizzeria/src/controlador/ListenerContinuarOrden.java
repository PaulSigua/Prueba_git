/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.DefaultListaClientes;
import vista.VistaOrdenes;

/**
 *
 * @author LENOVO
 */
public class ListenerContinuarOrden implements ActionListener{
    DefaultListaClientes listaClientes;
    VistaOrdenes v;

    public ListenerContinuarOrden(DefaultListaClientes listaClientes, VistaOrdenes v) {
        this.listaClientes = listaClientes;
        this.v = v;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        String[] cliente = v.getCliente();
        try {
            listaClientes.addCliente(new Cliente(cliente[0], cliente[1]));
        } catch (Exception ex) {
            Logger.getLogger(ListenerContinuarOrden.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("¡REGRESE PRONTO!");
    }
    
}
