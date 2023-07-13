/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.DefaultListaOrdenes;
import modelo.DefaultListaClientes;
import vista.VistaLista;
import vista.VistaOrdenes;
import vista.VistaServidos;

/**
 *
 * @author LENOVO
 */
public class ControladorOrdenes {

    DefaultListaOrdenes listaOrdenes; 
    VistaOrdenes vistaOrdenes;
    DefaultListaClientes listaClientes;
    VistaLista vistaLista;
    VistaServidos vistaServidos;

    public ControladorOrdenes(DefaultListaOrdenes listaOrdenes, DefaultListaClientes listaClientes, VistaOrdenes vistaOrdenes) {
        this.listaOrdenes = listaOrdenes;
        this.vistaOrdenes = vistaOrdenes; 
        this.vistaLista = new VistaLista();
        this.vistaServidos = new VistaServidos();
        
        ListenerAgregar la = new ListenerAgregar(listaOrdenes, listaClientes, vistaOrdenes);
        vistaOrdenes.addAgregarAL(la);
        vistaOrdenes.setModelo(listaOrdenes);
        vistaLista.setModeloOrdenPen(listaOrdenes);

        ListenerCancelarOrden lc = new ListenerCancelarOrden(listaOrdenes, vistaOrdenes);
        vistaOrdenes.addCancelarOrAL(lc);
        vistaOrdenes.setModeloCliente(listaOrdenes);

        ListenerIniciarPreparacion lip = new ListenerIniciarPreparacion(listaOrdenes, vistaOrdenes);
        vistaLista.setModeloOrdenPen(listaOrdenes);
        vistaLista.setModeloOrdenesPreparadas(listaOrdenes);

        ListenerLimpiar ll = new ListenerLimpiar(vistaOrdenes);
        vistaOrdenes.addLimpiarAL(ll);

        vistaOrdenes.setVisible(true);
        vistaLista.setVisible(true);
        vistaServidos.setVisible(true);

    }
}
