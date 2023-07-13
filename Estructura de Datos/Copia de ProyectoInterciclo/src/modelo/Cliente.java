 

package modelo;


public class Cliente implements Comparable{
    
    //Atributos
    private long id;
    private String nombre;
    private String apellido;
    private String estado;
    private int tiempoEspera;

    //Constructor
    
    public Cliente(long id, String nombre, String apellido, String estado, int tiempoEspera) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
        this.tiempoEspera = tiempoEspera;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    //To String
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", estado=" + estado + ", tiempoEspera=" + tiempoEspera + '}';
    }
    
    //Ordenar por apellido

    @Override
    public int compareTo(Object o) {
        Cliente cliente=(Cliente)o;
        return cliente.getApellido().compareTo(apellido);
    }

 
}
