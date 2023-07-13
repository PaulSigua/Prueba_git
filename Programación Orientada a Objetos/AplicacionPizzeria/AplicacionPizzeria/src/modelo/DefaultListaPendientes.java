package modelo;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author ADMIN
 */
public class DefaultListaPendientes extends AbstractListModel
{
    private ArrayList<Orden> listaPendientes;

    public DefaultListaPendientes() {
        listaPendientes = new ArrayList<>();
    }
    
    @Override
    public int getSize() {
        return listaPendientes.size();
    }

    @Override
    public Object getElementAt(int index) {
        try
        {
           return listaPendientes.get(index); 
        }
        catch(IndexOutOfBoundsException ex)
        {
            System.out.println("Para iniciar la preparación, debe por lo menos ingresar una orden");
            return null;
        }
    }
    
    public void addOrden(Orden orden)
    {
        listaPendientes.add(orden);
        int index = listaPendientes.size();
        fireIntervalAdded(this, index, index);
    }
    
    public void removeOrden(int index)
    {
        try
        {
            listaPendientes.remove(index);
            fireIntervalRemoved(this, index, index);
        }
        catch(IndexOutOfBoundsException ex)
        {
            System.out.println();
        }
    }
}
