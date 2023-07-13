
package MainConsola;

import vistaConsola.VistaCajeroConsola;
import vistaConsola.VistaClienteConsola;

public class ProyectoInterciclo {
    
    public static void main(String[] args) {
        java.util.Scanner teclado = new java.util.Scanner(System.in);
        
        VistaClienteConsola vistaCliente=new VistaClienteConsola();
        VistaCajeroConsola vistaCajero=new VistaCajeroConsola();
        
        int opc=0;
        do{
            System.out.println("==================================");
            System.out.println("|     Bienvenido al banco UPS    |");
            System.out.println("==================================");
            System.out.println("[1] <- Clientes");
            System.out.println("[2] <- Cajeros");
            System.out.println("[0] <- Salir");
            opc=teclado.nextInt();
            switch(opc){
                case 1 -> vistaCliente.menu();
                case 2 -> vistaCajero.menu();
                
                    
            }
        }while(opc!=0);
        
    }
    
  
}
