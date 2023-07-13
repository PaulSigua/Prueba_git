/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Vehiculo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TreeMap;

/**
 *
 * @author Adrian
 */
public class ControladorTurno {

    TreeMap<LocalDateTime, Vehiculo> Turnos;

    public ControladorTurno() {
        Turnos = new TreeMap<>();
    }
    
    public void Generarturno(LocalDateTime fecha, Vehiculo vehiculo) {
        Turnos.put(fecha, vehiculo);
    }

    public TreeMap<LocalDateTime, Vehiculo> listar() {
        return Turnos;
    }

}
