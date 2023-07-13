package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Vista1;
import modelo.DefaultListaOrden;
import modelo.DefaultListaPendientes;
import vista.Vista2;
/**
 *
 * @author ADMIN
 */
public class ListenerCancelar implements ActionListener
{
    Vista1 v1;
    Vista2 v2;
    DefaultListaOrden m1;
    DefaultListaPendientes m2;

    public ListenerCancelar(Vista1 v1, Vista2 v2, DefaultListaOrden m1, DefaultListaPendientes m2) {
        this.v1 = v1;
        this.v2 = v2;
        this.m1 = m1;
        this.m2 = m2;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int index = v1.getLista();
        m1.removeOrden(index);
        m2.removeOrden(index);
    }
}
