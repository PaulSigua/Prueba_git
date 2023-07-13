/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaOrdenes;

/**
 *
 * @author LENOVO
 */
public class ListenerLimpiar implements ActionListener{
    VistaOrdenes vistaOrdenes;

    public ListenerLimpiar(VistaOrdenes vistaOrdenes) {
        this.vistaOrdenes = vistaOrdenes;
    }

    

    @Override
    public void actionPerformed(ActionEvent arg0) {
        vistaOrdenes.getTamanio().clearSelection();
        vistaOrdenes.getTipo().clearSelection();
        vistaOrdenes.getBorde().clearSelection();
        vistaOrdenes.getExtras().clearSelection();
    }
    
}
