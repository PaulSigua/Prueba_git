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
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.DefaultListaClientes;
import modelo.Orden;
import modelo.DefaultListaOrdenes;
import vista.VistaOrdenes;

/**
 *
 * @author LENOVO
 */
public class ListenerAgregar implements ActionListener {

    DefaultListaOrdenes listaOrdenes;
    DefaultListaClientes listaClientes;
    VistaOrdenes v;

    public ListenerAgregar(DefaultListaOrdenes listaOrdenes, DefaultListaClientes listaClientes, VistaOrdenes v) {
        this.listaOrdenes = listaOrdenes;
        this.listaClientes = listaClientes;
        this.v = v;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String[] pedido = v.getPedido();
        String[] cliente = v.getCliente();
        try {
            listaOrdenes.addPedido(new Orden(pedido[0], pedido[1], pedido[2], pedido[3]));
            listaClientes.addCliente(new Cliente(cliente[0], cliente[1]));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(v, "Debe ingresar sus datos");
        } catch (Exception ex) {
            Logger.getLogger(ListenerAgregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
