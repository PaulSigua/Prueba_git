/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.DefaultListaOrdenes;
import vista.VistaOrdenes;

/**
 *
 * @author LENOVO
 */
public class ListenerCancelarOrden implements ActionListener{
    DefaultListaOrdenes listaOrdenes;
    VistaOrdenes v;

    public ListenerCancelarOrden(DefaultListaOrdenes listaOrdenes, VistaOrdenes v) {
        this.listaOrdenes = listaOrdenes;
        this.v = v;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        //v.cancelarOrden();
        listaOrdenes.cancelarOrden();
    }
}
