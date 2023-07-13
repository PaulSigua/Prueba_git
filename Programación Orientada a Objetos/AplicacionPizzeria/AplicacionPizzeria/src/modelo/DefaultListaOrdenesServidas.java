package modelo;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author ADMIN
 */
public class DefaultListaOrdenesServidas extends AbstractListModel 
{
    private ArrayList<Orden> listaServidas;

    public DefaultListaOrdenesServidas() {
        listaServidas = new ArrayList<>();
    }
    
    @Override
    public int getSize() {
        return listaServidas.size();
    }

    @Override
    public Object getElementAt(int index) {
        try
        {
           return listaServidas.get(index); 
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
        listaServidas.add(orden);
        int index = listaServidas.size();
        fireIntervalAdded(this, index, index);
    }
    
    public void removeOrden(int index)
    {
        try
        {
            listaServidas.remove(index);
            fireIntervalRemoved(this, index, index);
        }
        catch(IndexOutOfBoundsException ex)
        {
            System.out.println();
        }
    }
}
