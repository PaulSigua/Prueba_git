package controlador;

import modelo.DefaultListaOrden;
import modelo.DefaultListaPendientes;
import modelo.DefaultListaPreparaciones;
import modelo.DefaultListaOrdenesServidas;
import vista.Vista1;
import vista.Vista2;
import vista.Vista3;

/**
 *
 * @author ADMIN
 */
public class Controlador 
{
    DefaultListaOrden modeloListaOrdenes;
    DefaultListaPendientes modeloListaPendientes;
    DefaultListaPreparaciones modeloListaPreparaciones;
    DefaultListaOrdenesServidas modeloListaServidas;
    Vista1 v1;
    Vista2 v2;
    Vista3 v3;

    public Controlador(DefaultListaOrden modeloListaOrdenes, DefaultListaPendientes modeloListaPendientes, DefaultListaPreparaciones modeloListaPreparaciones, DefaultListaOrdenesServidas modeloListaServidas, Vista1 v1, Vista2 v2, Vista3 v3) {
        this.modeloListaOrdenes = modeloListaOrdenes;
        this.modeloListaPendientes = modeloListaPendientes;
        this.modeloListaPreparaciones = modeloListaPreparaciones;
        this.modeloListaServidas = modeloListaServidas;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        
        ListenerAgregarPedido la = new ListenerAgregarPedido(v1, modeloListaOrdenes, modeloListaPendientes);
        v1.addAgregarPedidoActionListener(la);
        
        ListenerCancelar lc = new ListenerCancelar(v1, v2, modeloListaOrdenes, modeloListaPendientes);
        v1.addCancelarPedidoActionListener(lc);
        
        ListenerIniciarPreparacion li = new ListenerIniciarPreparacion(v1, v2, modeloListaOrdenes, modeloListaPendientes, modeloListaPreparaciones);
        v2.addIniciarPreparacionActionListener(li);
        
        ListenerOrdenLista lo = new ListenerOrdenLista(v1, v2, v3, modeloListaPreparaciones, modeloListaServidas);
        v2.addOrdenListaActionListener(lo);
        
        v1.setModelo(modeloListaOrdenes, modeloListaPreparaciones, modeloListaServidas);
        v2.setModelo(modeloListaPendientes, modeloListaPreparaciones);
        v3.setModelo(modeloListaServidas);
        v1.setVisible(true);
        v2.setVisible(true);
        v3.setVisible(true);
        v1.setLocationRelativeTo(null);
        v2.setLocationRelativeTo(null);
        v3.setLocationRelativeTo(null);
    }

    

    

    
}
