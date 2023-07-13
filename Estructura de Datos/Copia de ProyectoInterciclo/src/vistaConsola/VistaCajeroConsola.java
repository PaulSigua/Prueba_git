
package vistaConsola;

import controlador.ControladorCajero;
import java.time.LocalTime;
import java.util.Scanner;
import modelo.Cajero;


public class VistaCajeroConsola {
    Scanner teclado;
    ControladorCajero controladorCajero;
    
    public VistaCajeroConsola(){
        teclado=new Scanner(System.in);
        controladorCajero=new ControladorCajero();
    }
    
    public void menu(){
        int opc=0;
        do{
            System.out.println("\n• • • • • Menu Cajero • • • • • \n" +
                               "1 Crear cajeros " +
                               "2 Listar Cajeros" +
                               "[3] Buscar Cajero" +
                               "[0] Salir ");
            opc=teclado.nextInt();
            switch(opc){
                case 1: crearCajeros();
                case 2: listarCajeros();
            }
            
        }while(opc!=0);
    }
    
    public void crearCajeros(){
        System.out.println("Numero de cajeros con los que se cuenta 10");
            System.out.println("\n\n-Porfavor Ingrese los Datos");
            System.out.println("Ingrese el numero de cajeros a crear: ");
            int numero=teclado.nextInt();
            for(int i=1;i<=numero;i++){
                System.out.println("\n-----------------------------");
                System.out.println("Cliente: "+controladorCajero.generarId());
                System.out.println("Hora de llegada: ");
                LocalTime horaLlegada=LocalTime.parse(teclado.next());
                System.out.println("Hora de salida: ");
                LocalTime horaSalida=LocalTime.parse(teclado.next());
                Cajero cajero=new Cajero(controladorCajero.generarId(), controladorCajero.nombreCajero(), horaLlegada, horaSalida, controladorCajero.horaFijo(), numero);
                controladorCajero.crearCajero(cajero);
                controladorCajero.horaFijo();
            }
    }
    
    public void listarCajeros(){
        controladorCajero.listar();
    }   
}
