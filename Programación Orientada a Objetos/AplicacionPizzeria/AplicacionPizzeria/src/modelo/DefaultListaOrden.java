package modelo;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author ADMIN
 */
public class DefaultListaOrden extends AbstractListModel
{
    private ArrayList<Orden> listaOrdenes;

    public DefaultListaOrden() {
        listaOrdenes = new ArrayList<>();
    }
    
    @Override
    public int getSize() {
        return listaOrdenes.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listaOrdenes.get(index);
    }
    
    public void addOrden(Orden orden)
    {
        listaOrdenes.add(orden);
        int index = listaOrdenes.size();
        fireIntervalAdded(this, index, index);
    }
    
    public void removeOrden(int index)
    {
        try
        {
            listaOrdenes.remove(index);
            fireIntervalRemoved(this, index, index);
        }
        catch(IndexOutOfBoundsException ex)
        {
            System.out.println("ERROR: "+ex.getMessage());
            System.out.println("Para cancelar una orden debe por lo menos ingresar una");
        }
    }
}
