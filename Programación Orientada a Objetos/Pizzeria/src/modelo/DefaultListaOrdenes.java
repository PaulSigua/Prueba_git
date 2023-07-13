/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import vista.VistaOrdenes;

/**
 *
 * @author LENOVO
 */
public class DefaultListaOrdenes extends AbstractListModel<Orden>{
    private ArrayList<Orden> listaOrdenes;
    VistaOrdenes v;

    public DefaultListaOrdenes() {
        this.listaOrdenes = new ArrayList();
        v = new VistaOrdenes();
    }
    
    @Override
    public int getSize() {
        return listaOrdenes.size();
    }

    @Override
    public Orden getElementAt(int index) {
        return listaOrdenes.get(index);
    }
    
    public void addPedido(Orden orden){
        listaOrdenes.add(orden);
        int index = listaOrdenes.size();
        fireIntervalAdded(this, index, index);
    }
    
    public void limpiar(int index){
        listaOrdenes.remove(index);
    }
    
    public void cancelarOrden(){
        listaOrdenes.removeAll(listaOrdenes);
    }
}
