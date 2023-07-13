
package modelo;

import java.time.LocalTime;


public class Cajero {
    
    //Atributos
    
    private long id;
    private String nombre;
    private LocalTime horaLLegada;
    private LocalTime horaSalida;
    private int horaFijo;
    private int numeroCajeros;

    //Constructor
    
    public Cajero(long id, String nombre, LocalTime horaLLegada, 
            LocalTime horaSalida, int horaFijo, int numeroCajeros) {
        this.id = id;
        this.nombre = nombre;
        this.horaLLegada = horaLLegada;
        this.horaSalida = horaSalida;
        this.horaFijo = horaFijo;
        this.numeroCajeros = numeroCajeros;
    }

    
    //Getters y Setters

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

    public int getNumeroCajeros() {
        return numeroCajeros;
    }

    public void setNumeroCajeros(int numeroCajeros) {
        this.numeroCajeros = numeroCajeros;
    }

    public LocalTime getHoraLLegada() {
        return horaLLegada;
    }

    public void setHoraLLegada(LocalTime horaLLegada) {
        this.horaLLegada = horaLLegada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getHoraFijo() {
        return horaFijo;
    }

    public void setHoraFijo(int horaFijo) {
        this.horaFijo = horaFijo;
    }
    
    //To String

    @Override
    public String toString() {
        return "Cajero{" + "id=" + id + ", nombre=" + nombre + ", horaLLegada=" + horaLLegada + ", horaSalida=" + horaSalida + ", horaFijo=" + horaFijo + '}';
    }
    
    
    
    

    
    
    

}