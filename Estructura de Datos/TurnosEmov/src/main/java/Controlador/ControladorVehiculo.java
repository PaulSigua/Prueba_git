/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Adrian
 */
public class ControladorVehiculo {

    private Random rand;
    private static List<Vehiculo> vehiculos;

    public void generarNVehiculos(int n) {
        for (int i = 0; i < n; i++) {
            generarVehiculo();
        }
    }

    public void generarVehiculo() {
        Vehiculo vehiculo = new Vehiculo(generarPlaca());
        while (vehiculos.contains(vehiculo)) {
            vehiculo = new Vehiculo(generarPlaca());
        }
        vehiculos.add(vehiculo);
    }

    public ControladorVehiculo() {
        rand = new Random();
        vehiculos = new ArrayList<>();
    }

    public String generarPlaca() {
        return generarLetras() + "-" + generarNumeros();
    }

    private String generarLetras() {
        String result = "";
        for (int i = 0; i < 3; i++) {
            result += getRandomCharacter();
        }
        return result.toUpperCase();
    }

    private String generarNumeros() {
        String result = "";
        for (int i = 0; i < 3; i++) {
            result += getRandomNumber();
        }
        return result;
    }

    private char getRandomCharacter() {
        return (char) (rand.nextInt(26) + 'a');
    }

    private int getRandomNumber() {
        return (int) rand.nextInt(10);
    }

    public Vehiculo GetByPos(int pos) {
        return vehiculos.get(pos);
    }

    public List<Vehiculo> listar() {
        return vehiculos;
    }

}
