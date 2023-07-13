package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.DefaultListaOrdenesServidas;
import vista.Vista1;
import vista.Vista2;
import vista.Vista3;
import modelo.DefaultListaPreparaciones;
import modelo.Orden;
/**
 *
 * @author ADMIN
 */
public class ListenerOrdenLista implements ActionListener
{
    Vista1 v1;
    Vista2 v2;
    Vista3 v3;
    DefaultListaPreparaciones m1;
    DefaultListaOrdenesServidas m2;

    public ListenerOrdenLista(Vista1 v1, Vista2 v2, Vista3 v3, DefaultListaPreparaciones m1, DefaultListaOrdenesServidas m2) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.m1 = m1;
        this.m2 = m2;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int index = v2.getListaPreparaciones();
        m2.addOrden((Orden) m1.getElementAt(index));
        m1.removeOrden(index);
    }
}
