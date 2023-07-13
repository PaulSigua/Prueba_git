package model;

import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import view.*;

/**
 *
 * @author mateo
 */
public class DefaultTableClient extends AbstractTableModel {

    DefaultListClient listClient;
    RechargeInformation rechargeInfo;
    private String[] info = new String[]{"Linea Teléfonica", "Nombre", "Cédula", "N. de Teléfono", "Edad"};
        
    public class ListenerListClient implements ListDataListener {

        @Override
        public void intervalAdded(ListDataEvent e) {
            fireTableDataChanged();
        }

        @Override
        public void intervalRemoved(ListDataEvent e) {
            fireTableDataChanged();
        }

        @Override
        public void contentsChanged(ListDataEvent e) {
            fireTableDataChanged();
        }

    }
    
    public DefaultTableClient(DefaultListClient listClient) {
        this.listClient = listClient;
        ListenerListClient listenerClient = new ListenerListClient();
        listClient.addListDataListener(listenerClient);
    }

    @Override
    public int getRowCount() {
        return listClient.getSize();
    }

    @Override
    public int getColumnCount() {
        return info.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listClient.getElementAt(rowIndex).getNameLine();
            case 1:
                return listClient.getElementAt(rowIndex).getName();
            case 2:
                return listClient.getElementAt(rowIndex).getId();
            case 3:
                return listClient.getElementAt(rowIndex).getCell();
            case 4:
                return listClient.getElementAt(rowIndex).getAge();
            default:
                return "No existe información";
        }
    }
    
    @Override
    public String getColumnName(int column){
        return info[column];
    }

}
