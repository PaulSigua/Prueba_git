package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Vista1;
import modelo.DefaultListaOrden;
import modelo.Orden;
import modelo.DefaultListaPendientes;
/**
 *
 * @author ADMIN
 */
public class ListenerAgregarPedido implements ActionListener
{
    Vista1 v;
    DefaultListaOrden m1;
    DefaultListaPendientes m2;

    public ListenerAgregarPedido(Vista1 v, DefaultListaOrden m1, DefaultListaPendientes m2) {
        this.v = v;
        this.m1 = m1;
        this.m2 = m2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String []informacion = v.getInfo();
        if(informacion[0] == "<>" || informacion[1] == "<>" || informacion[2] == "<>" || informacion[3] == "<>")
        {
            System.out.println("Para agregar una orden debe completar todos los campos");
        } 
        else 
        {
            m1.addOrden(new Orden (informacion[0],informacion[1],informacion[2], informacion[3]));
            m2.addOrden(new Orden (informacion[0],informacion[1],informacion[2], informacion[3]));
        }
    }
}
