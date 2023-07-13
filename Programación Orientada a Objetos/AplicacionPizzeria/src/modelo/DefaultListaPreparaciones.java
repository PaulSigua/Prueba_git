package modelo;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author ADMIN
 */
public class DefaultListaPreparaciones extends AbstractListModel
{
    private ArrayList<Orden> listaPreparaciones;

    public DefaultListaPreparaciones() {
        listaPreparaciones = new ArrayList<>();
    }
    
    @Override
    public int getSize() {
        return listaPreparaciones.size();
    }

    @Override
    public Object getElementAt(int index) {
        try
        {
           return listaPreparaciones.get(index); 
        }
        catch(IndexOutOfBoundsException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Para servir una orden debe por lo menos tener una orden preparandose");
            return null;
        }
    }
    
    public void addOrden(Orden orden)
    {
        listaPreparaciones.add(orden);
        int index = listaPreparaciones.size();
        fireIntervalAdded(this, index, index);
    }
    
    public void removeOrden(int index)
    {
        try
        {
            listaPreparaciones.remove(index);
            fireIntervalRemoved(this, index, index);
        }
        catch(IndexOutOfBoundsException ex)
        {
            System.out.println();
        }
    }
}
