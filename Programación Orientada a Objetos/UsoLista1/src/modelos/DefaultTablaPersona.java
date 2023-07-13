/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;
import javax.swing.table.AbstractTableModel;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListDataEvent;

/**
 *
 * @author Alienware
 */
public class DefaultTablaPersona extends AbstractTableModel{
    DefaultListaPersonas listaPersonas;
    
    private class ListenerListaPersonas implements ListDataListener{

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
    
    public DefaultTablaPersona(DefaultListaPersonas listaPersonas) {
        this.listaPersonas = listaPersonas;
        ListenerListaPersonas llp = new ListenerListaPersonas();
        listaPersonas.addListDataListener(llp);
    }
    
    @Override
    public int getRowCount() {
        return listaPersonas.getSize();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch(col){
            case 0:
                return listaPersonas.getElementAt(row).getNombre();
            case 1:
                return listaPersonas.getElementAt(row).getDireccion();
            case 2:
                return listaPersonas.getElementAt(row).getId();
            default:
                return "";
        }
    }   
}
