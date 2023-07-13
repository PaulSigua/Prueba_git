/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.modelo;

/**
 *
 * @author guama
 */
public class Persona {
    private int id;
    private String cedula,nombre,apellido,direccion,telefono,correo;
    private char tipo,estado;

    public Persona() {
    }

    public Persona(int id, String cedula, String nombre, String apellido, String direccion, String telefono, String correo, char tipo, char estado) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.tipo = tipo;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public char getTipo() {
        return tipo;
    }

    public char getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", telefono=" + telefono + ", correo=" + correo + ", tipo=" + tipo + ", estado=" + estado + '}';
    }
    
}
