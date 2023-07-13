/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.TreeMap;
import modelo.Jugador;

/**
 *
 * @author UPS
 */
public class ControladorJugador {
    
    TreeMap<String, Jugador> mapJugadores;
    public ControladorJugador(){
        mapJugadores = new TreeMap();
    }
    public long generarId(){
        return mapJugadores.isEmpty() ? 1: mapJugadores.lastEntry().getValue().getId()+1;
    }
    public boolean crear(Jugador jugador){
        return mapJugadores.put(jugador.getNombre(), jugador) == null;
    }
    public boolean eliminar(Jugador jugador){
        return mapJugadores.remove(jugador.getNombre())== null;
    }
    public boolean buscarByNombre(String nombre){
        return mapJugadores.containsKey(nombre);
    }
    public boolean actualizar(Jugador jugador){
        return mapJugadores.replace(jugador.getNombre(), jugador)==null;
    }

    public TreeMap<String, Jugador> getMapJugadores() {
        return mapJugadores;
    }

    public void setMapJugadores(TreeMap<String, Jugador> mapJugadores) {
        this.mapJugadores = mapJugadores;
    }
    
}
