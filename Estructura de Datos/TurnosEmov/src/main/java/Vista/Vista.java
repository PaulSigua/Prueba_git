/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.ControladorTurno;
import Controlador.ControladorVehiculo;
import Modelo.Vehiculo;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Adrian
 */
public class Vista {

    private static ControladorVehiculo controlarVehiculo;
    private static ControladorTurno controladorTurno;
    private Scanner keyboard;

    public Vista() {
        controlarVehiculo = new ControladorVehiculo();
        controladorTurno = new ControladorTurno();
        keyboard = new Scanner(System.in);
    }

    public void menu() {
        int op;
        do {
            System.out.println("1. Generar 100 vehiculos");
            System.out.println("2. Listar Vehiculos");
            System.out.println("3. Generar Turno");
            System.out.println("4. Lista de Turnos");
            System.out.println("0. Salir");
            op = keyboard.nextInt();
            switch (op) {
                case 1:
                    generarVehiculos();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    GenerarTurno();
                    break;
                case 4:
                    ListarTurnos();
                    break;

            }
        } while (op != 0);
    }

    private void generarVehiculos() {
        controlarVehiculo.generarNVehiculos(100);
    }

    private void listar() {
        List<Vehiculo> vehiculos = controlarVehiculo.listar();
        for (Vehiculo v : vehiculos) {
            System.out.println(v);
        }
    }

    private void GenerarTurno() {
        System.out.println("Ingrese la posicion del vehiculo");
        int pos = keyboard.nextInt();
        List<Vehiculo> vehiculos = controlarVehiculo.listar();
        Vehiculo vehiculo = vehiculos.get(pos);
        LocalDateTime fecha = null;
        int op = 0;
        do {
            if (op == 1 && op == 2) {
                break;
            }
            System.out.println("1. Fecha Actual");
            System.out.println("2. Ingresar fecha");
            op = keyboard.nextInt();
            switch (op) {
                case 1:
                    fecha = LocalDateTime.now();
                    break;
                case 2:
                    fecha = GenFecha();
                    break;
            }
        } while (op != 0);
        controladorTurno.Generarturno(fecha, vehiculo);
    }

    private LocalDateTime GenFecha() {
        int y;
        int m;
        int d;
        int Hora;
        int Min;
        System.out.println("Ingrese el año");
        y = keyboard.nextInt();
        System.out.println("Ingrese el Mes");
        m = keyboard.nextInt();
        System.out.println("Ingrese el Día");
        d = keyboard.nextInt();
        System.out.println("Ingrese la Hora");
        Hora = keyboard.nextInt();
        System.out.println("Ingrese los minutos");
        Min = keyboard.nextInt();
        return LocalDateTime.of(y, m, d, Hora, Min);
    }

    private void ListarTurnos() {
        TreeMap<LocalDateTime, Vehiculo> tunosMap = controladorTurno.listar();
        System.out.println(tunosMap.values());
    }
}
