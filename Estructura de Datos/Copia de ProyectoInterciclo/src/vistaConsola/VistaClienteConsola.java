
package vistaConsola;

import controlador.ControladorCliente;
import java.time.LocalDate;
import java.util.Scanner;
import javax.swing.JOptionPane;
import modelo.Cliente;


public class VistaClienteConsola {
    Scanner teclado; 
    ControladorCliente controladorCliente;
    
    public VistaClienteConsola(){
        controladorCliente=new ControladorCliente();
        teclado = new Scanner(System.in);
    }
    
    public void menu(){
        int opc=0;
        do{
            System.out.println("""
                               \n• • Menu Cliente • •\n
                               [1] Generar clientes
                               [2] Listar
                               [3] Tiempo de atencion
                               [4] Atender Cliente
                               [0] Salir
                               """);
            opc=teclado.nextInt();
            switch (opc) {
                case 1 -> agregar();
                case 2 -> listado();
                case 3 -> tiempoAtencion();
                case 4 -> atenderClientes();
                    
            }
        }while(opc!=0);
    }
    
    public void agregar(){
        int option=0;
        do{
            System.out.println("""
                               \n-Escriba su opcion: 
                               [1] Reservar turno
                               [2] Crear Turno
                               [0] Salir
                               """);
            option=teclado.nextInt();
            switch(option){
                case 1 -> {
                    System.out.println("\n-Porfavor Ingrese sus Datos\n");
                    System.out.println("Ingrese la fecha la cual desea su turno\n(Año-Mes-Dia)");
                    LocalDate fecha=LocalDate.parse(teclado.next());
                    System.out.println("* * * * * Registro realizado con exito * * * * *");
                    System.out.println("Porfavor Ingrese sus datos para completar el registro de turno:\n");
                    System.out.println("Ingrese su nombre");
                    String nombre0=teclado.next();
                    System.out.println("Ingrese su apellido");
                    String apellido0=teclado.next();
                    Cliente cliente0=new Cliente(controladorCliente.generarId(), 
                            nombre0, apellido0, controladorCliente.estadoCliente(), controladorCliente.tiempoEspera());
                    controladorCliente.crear(cliente0);
                    controladorCliente.crearLista(cliente0);
                    controladorCliente.comprobanteEntrada(cliente0);
                }
                case 2 -> {
                    System.out.println("-Porfavor Ingrese sus Datos\n");
                    System.out.println("Ingrese su nombre");
                    String nombre=teclado.next();
                    System.out.println("Ingrese su apellido");
                    String apellido=teclado.next();
                    Cliente cliente=new Cliente(controladorCliente.generarId(), 
                            nombre, apellido, controladorCliente.estadoCliente(), controladorCliente.tiempoEspera());
                    controladorCliente.crear(cliente);
                    controladorCliente.crearLista(cliente);
                    controladorCliente.comprobanteEntrada(cliente);
                }
                
            } JOptionPane.showMessageDialog(parentComponent, teclado);
   
        }while(option!=0);
    }
        
    public void listado(){
        int opc=0;
        do{
            System.out.println("\n* * * Menu listar * * *\n");
            System.out.println("[1] Listar");
            System.out.println("[2] Ordenar por tiempo de espera");
            System.out.println("[3] Ordenar por apellido");
            System.out.println("[0] Salir");
            opc=teclado.nextInt();
            switch(opc){
                case 1 -> controladorCliente.listar();
                case 2 -> controladorCliente.ordenarTiempoEspera();
                case 3 -> controladorCliente.ordenarClienteApellido();
            }
            
        }while(opc!=0);
    }
    
    public void tiempoAtencion(){
        System.out.println("Ingrese su nombre:");
        String nombre=teclado.next(); 
        Cliente cliente=controladorCliente.buscarCliente(nombre);
        controladorCliente.tiempoAtencionCliente(cliente);
    }
    
    public void atenderClientes(){
        controladorCliente.atenderCliente();
    }
    
}
