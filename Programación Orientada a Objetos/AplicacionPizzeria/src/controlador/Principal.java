package controlador;
import modelo.DefaultListaOrden;
import modelo.DefaultListaOrdenesServidas;
import modelo.DefaultListaPendientes;
import modelo.DefaultListaPreparaciones;
import vista.Vista1;
import vista.Vista2;
import vista.Vista3;

/**
 *
 * @author ADMIN
 */
public class Principal 
{
    public static void main(String[] args) 
    {
        DefaultListaOrden m1 = new DefaultListaOrden();
        DefaultListaPendientes m2 = new DefaultListaPendientes();
        DefaultListaPreparaciones m3 = new DefaultListaPreparaciones();
        DefaultListaOrdenesServidas m4 = new DefaultListaOrdenesServidas(); 
        Vista1 v1 = new Vista1();
        Vista2 v2 = new Vista2();
        Vista3 v3 = new Vista3();
        Controlador c = new Controlador(m1,m2,m3,m4,v1,v2,v3);
    }
}
