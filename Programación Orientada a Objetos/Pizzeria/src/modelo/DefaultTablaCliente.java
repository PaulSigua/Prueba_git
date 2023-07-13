/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author LENOVO
 */
public class DefaultTablaCliente extends AbstractTableModel{
    DefaultListaClientes listaClientes;

    public class ListenerListCliente implements ListDataListener{

        @Override
        public void intervalAdded(ListDataEvent arg0) {
            fireTableDataChanged();
        }

        @Override
        public void intervalRemoved(ListDataEvent arg0) {
            fireTableDataChanged();    
        }

        @Override
        public void contentsChanged(ListDataEvent arg0) {
            fireTableDataChanged();
        }
        
    }

    public DefaultTablaCliente(DefaultListaClientes listaClientes) {
        this.listaClientes = listaClientes;
        ListenerListCliente llc = new ListenerListCliente();
        listaClientes.addListDataListener(llc);
    }
    
    @Override
    public int getRowCount() {
        return listaClientes.getSize();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch(col){
            case 0:
                return listaClientes.getElementAt(row).getNombre();
            case 1:
                return listaClientes.getElementAt(row).getCedula();
            default:
                return "";
        }
    }
    
}
