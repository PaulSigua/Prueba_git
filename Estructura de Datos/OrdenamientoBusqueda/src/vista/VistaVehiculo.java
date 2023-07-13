/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorVehiculo;
import java.util.Random;
import java.util.Scanner;
import modelo.Vehiculo;

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
            System.out.println("1. Generar");
            System.out.println("2. Buscar");
            System.out.println("3. Ordenar Asc");
            System.out.println("4. Ordenar Desc");
            System.out.println("5. Listar");
            System.out.println("0. Salir");
            opc = teclado.nextInt();
            switch(opc){
                case 1: generar(); break;
                case 2: buscar(); break;
                case 3: controladorVehiculo.ordenarAsc();break;
                case 4: controladorVehiculo.ordenarDes();break;
                case 5: listar();break;
            }
        } while (opc!=0);
    }
    public void generar(){
        System.out.println("Ingrese la cantidad");
        int cantidad = teclado.nextInt();
        for (int i = 0; i < cantidad; i++) {
            Vehiculo vehiculo = new Vehiculo(i, generarPlaca(), random.nextDouble()*10000);
            controladorVehiculo.crear(vehiculo);
        }
    }
    public String generarPlaca(){
        String placa = "";
        for (int i = 0; i < 3; i++) {
            placa += random.nextInt(10);
        }
        return placa;
    }
    public void buscar(){
        System.out.println("Ingrese la placa");
        String placa = teclado.next();
        Vehiculo vehiculo = controladorVehiculo.buscar(placa);
        System.out.println(vehiculo);
    }
    public void listar(){
        controladorVehiculo.getListaVehiculo().forEach(v -> System.out.println(v));
    }
}
