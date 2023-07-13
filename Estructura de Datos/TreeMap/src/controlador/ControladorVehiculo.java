/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.TreeMap;
import modelo.Vehiculo;

/**
 *
 * @author UPS
 */
public class ControladorVehiculo {
    TreeMap<String, Vehiculo> listVehiculo;
    public ControladorVehiculo(){
        listVehiculo = new TreeMap();
    }
    public long generarId(){
        return listVehiculo.isEmpty()? 1: listVehiculo.lastEntry().getValue().getId()+1;
    }
    public boolean crear(Vehiculo vehiculo){
        return listVehiculo.put(vehiculo.getPlaca(), vehiculo) == null;
    }
    public boolean actualizar(Vehiculo vehiculo){
        return listVehiculo.replace(vehiculo.getPlaca(), vehiculo) != null;
    }
    public Vehiculo buscar(String placa){
        return listVehiculo.get(placa);
    }
    public boolean eliminar(Vehiculo vehiculo){
        return listVehiculo.remove(vehiculo.getPlaca()) != null;
    }

    public TreeMap<String, Vehiculo> getListVehiculo() {
        return listVehiculo;
    }

    public void setListVehiculo(TreeMap<String, Vehiculo> listVehiculo) {
        this.listVehiculo = listVehiculo;
    }
    
    
}
