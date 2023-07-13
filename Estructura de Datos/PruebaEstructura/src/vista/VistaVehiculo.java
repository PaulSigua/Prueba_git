
package vista;

import controlador.ControladorVehiculo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import modelo.Nodo;

public class VistaVehiculo {
    ControladorVehiculo controladorVehiculo;
    Scanner teclado;
    Random random;
    public VistaVehiculo(){
        controladorVehiculo = new ControladorVehiculo();
        teclado = new Scanner(System.in);
        random = new Random();
    }
    public void menu(){
        int opc = 0;
        do {            
            System.out.println("----------------------------------");
            System.out.println("     TURNOS EMOV  ¡BIENVENID@!    ");
            System.out.println("   Ingrese una opción por favor");
            System.out.println("1. Generar AUTOS");
            System.out.println("2. Imprimir AUTOS");
            System.out.println("3. Ordenamiento de la placa");
            System.out.println("4. Ordenamiento por fecha");
            System.out.println("5. Busqueda binaria");
            System.out.println("6. Busqueda secuencial");
            System.out.println("7. Listar");
            System.out.println("0. Salir");
            System.out.println("----------------------------------");
            opc = teclado.nextInt();
            switch(opc){
                case 1: generar(); break;
                case 2: listar(); break;
                case 3: controladorVehiculo.ordenarAsc(); break;
                case 4: controladorVehiculo.ordenDes(); break;
                case 5: buscarBinaria(); break;
                case 6: buscarSecuencial(); break;
                case 7: listar(); break;
            }
        } while (opc!=0);
    }
    
    public void generar(){
        for (int i = 0; i < 100; i++) {
            Nodo nodo = new Nodo(generarPlaca(), LocalDate.now(), generarHour());
            controladorVehiculo.crear(nodo);
        }
    }
    
    public String generarNumeros(){
        String placa = "";
        for (int i = 0; i < 4; i++) {
            placa += random.nextInt(10);
        }
        return placa;
    }
    
    public String generarLetra(){
        String placa ="";
        for(int i = 0; i < 3; i++){
            placa += "" + (char)(random.nextInt(27)+'A');
        }
        return placa;
    }
    
    public String generarPlaca(){
        return generarLetra() + "-" + generarNumeros() ;
    }
    /*
    public String generarDia(){
        String dia = "";
        for (int i = 0; i < 1; i++) {
            dia += random.nextInt(31);
        }
        return dia;
    }
    
    public String generarMes(){
        String mes = "";
        for (int i = 0; i < 1; i++) {
            mes += random.nextInt(12);
        }
        return mes;
    }
    
    public String generarAnio(){
        String anio = "";
        for (int i = 0; i < 1; i++) {
            if( i < 2023 && i > 2022)
                  anio += random.nextInt(2023);
        }
        return anio;
    }
    
    public String generarDate(){
        return generarDia() + "/" + generarMes() + "/" + generarAnio();
    }*/
    
    public String generarMin(){
        String min= "";
        for(int i = 0; i < 1; i++){
            min += random.nextInt(60);
        }
        return min;
    }
    
    public String generarHora(){
        String hora = "";
        for(int i = 0; i < 1; i++){
            hora += random.nextInt(19);
        }
        return hora;
    }
    
    public String generarHour(){
        return generarHora() + ":" + generarMin();
    }
    public void buscarSecuencial(){
        System.out.println("Ingrese la placa: ");
        String nombre = teclado.next();
        int placa = controladorVehiculo.busquedaSecuencial(nombre);
        System.out.println("La placa que busca es: " + nombre + ", y esta  en la posicion: " + placa);
    }
    
    public void buscarBinaria(){
        System.out.println("Ingrese la fecha: ");
        String nombre = teclado.next();
        int hora = controladorVehiculo.busquedaBinaria(nombre);
        System.out.println("La hora que busca es: " + nombre + ", y esta en la posicion: " + hora);
    }
    
    public void listar(){
        System.out.println("--------------------------------------------------------------------------");
        controladorVehiculo.getListaVehiculo().forEach(v -> System.out.println(v));
    }

}
