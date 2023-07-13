/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import modelo.Vehiculo;

/**
 *
 * @author UPS
 */
public class ControladorVehiculo {
    private List<Vehiculo>  listaVehiculo;
    public ControladorVehiculo(){
        listaVehiculo = new ArrayList();
    }
    public boolean crear(Vehiculo vehiculo){
        return listaVehiculo.add(vehiculo);
    }
    public Vehiculo buscar(String placa){
        return listaVehiculo.stream().filter(v -> v.getPlaca().equals(placa)).findFirst().get();
    }
    
    
    
    public void ordenarAsc(){
        //listaVehiculo = listaVehiculo.stream().sorted(Comparator.comparing(Vehiculo::getPlaca)).collect(Collectors.toList());
        listaVehiculo = listaVehiculo.stream().sorted().collect(Collectors.toList());
    }
    
    
    
    
    
    
    public void ordenarDes(){
        listaVehiculo = listaVehiculo.stream().sorted(Comparator.comparing(Vehiculo::getPlaca).reversed()).collect(Collectors.toList());
    }

    public List<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(List<Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }
    
}
