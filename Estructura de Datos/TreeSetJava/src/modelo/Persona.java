package modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author UPS
 * implemnto el comparable para ordenar por la prioridad
 */
public class Persona implements Comparable<Persona>{
    private long id;
    private String nombre;

    public Persona(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "id: " + id + ", nombre: " + nombre + '}';
    }
    //Ordenar por prioridad
    /*
    @Override
    public int compareTo(Persona p) {
        //return nombre.compareTo(p.getNombre());
        if(prioridad > p.getPrioridad() ){
            return 1;
        }else if(prioridad < p.getPrioridad()){
            return -1;
        }else{
            return 0;
        }
    }
    */
    // Ordenar por nombre
    @Override
    public int compareTo(Persona p) {
        return nombre.compareTo(p.getNombre());
    }
    
}
