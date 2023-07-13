package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.DefaultListaOrden;
import vista.Vista2;
import modelo.DefaultListaPendientes;
import modelo.DefaultListaPreparaciones;
import modelo.Orden;
import vista.Vista1;
/**
 *
 * @author ADMIN
 */
public class ListenerIniciarPreparacion implements ActionListener
{
    Vista1 v1;
    Vista2 v2;
    DefaultListaOrden m1;
    DefaultListaPendientes m2;
    DefaultListaPreparaciones m3;

    public ListenerIniciarPreparacion(Vista1 v1, Vista2 v2, DefaultListaOrden m1, DefaultListaPendientes m2, DefaultListaPreparaciones m3) {
        this.v1 = v1;
        this.v2 = v2;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = v2.getListaPendientes();
        m1.removeOrden(index);
        m3.addOrden((Orden) m2.getElementAt(index)); 
        m2.removeOrden(index);
    }
}
