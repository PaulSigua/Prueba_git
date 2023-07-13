/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorVehiculo;
import static java.lang.Math.random;
import java.util.Random;
import java.util.Scanner;
import modelo.Vehiculo;

/**
 *
 * @author UPS
 */
public class VistaVehiculo {

    ControladorVehiculo controladorVehiculo;
    Scanner teclado;
    Random random;

    public VistaVehiculo() {
        controladorVehiculo = new ControladorVehiculo();
        teclado = new Scanner(System.in);
        random = new Random();
    }

    public void menu() {
        int opc = 0;
        do {
            System.out.println("1. Crear \n2. Listar \n3. Generar \n4. Listar 3 \n0. Salir");
            opc = teclado.nextInt();
            switch (opc) {
                case 1:
                    crear();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    generarAuto();
                    break;
                case 4: 
                    listarAuto();
            }
        } while (opc != 0);
    }

    public void crear() {
        System.out.println("Ingresar Placa");
        String placa = teclado.next();
        System.out.println("Ingresar Año");
        int anio = teclado.nextInt();
        Vehiculo vehiculo = new Vehiculo(controladorVehiculo.generarId(), placa, anio);
        System.out.println(controladorVehiculo.crear(vehiculo));
    }

    public void listar() {
        controladorVehiculo.getListVehiculo().forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    public void generarAuto() {
        for (int i = 0; i < 10; i++) {
            Vehiculo v = new Vehiculo(i, "UPS-" + (i + 1), random.nextInt(5));
            controladorVehiculo.crear(v);
        }
    }
    
    public void listarAuto(){
        controladorVehiculo.getListVehiculo().forEach((k,v) -> System.out.println(k + " -> " + v));
    }
}