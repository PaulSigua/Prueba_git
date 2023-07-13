
package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Nodo implements Comparable<Nodo>{
    private String placa;
    private LocalDate fecha;
    private String hora;
    private Nodo siguiente;
    private Nodo anterior;
    
    public Nodo(String placa, LocalDate fecha, String hora){
        this.placa = placa;
        this.fecha = fecha;
        this.hora = hora;
        this.siguiente = null;
        this.anterior = null;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "Placa: [" + placa + "]; La fecha de su turno es: " + fecha + "  Su hora: " + hora;
    }

    @Override
    public int compareTo(Nodo nodo) {
        return placa.compareTo(placa);
    }

}
