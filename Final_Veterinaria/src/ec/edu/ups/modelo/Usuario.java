/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.modelo;

/**
 *
 * @author guama
 */
public class Usuario {
    private int id,per_id;
    private String nombre_usuario,clave;
    private char encargo,estado;

    public Usuario() {
    }

    public Usuario(int id, char encargo, String nombre_usuario, String clave, char estado, int per_id) {
        this.id = id;
        this.per_id = per_id;
        this.nombre_usuario = nombre_usuario;
        this.clave = clave;
        this.encargo = encargo;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public int getPer_id() {
        return per_id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getClave() {
        return clave;
    }

    public char getEncargo() {
        return encargo;
    }

    public char getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPer_id(int per_id) {
        this.per_id = per_id;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setEncargo(char encargo) {
        this.encargo = encargo;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    
    
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", per_id=" + per_id + ", nombre_usuario=" + nombre_usuario + ", clave=" + clave + ", encargo=" + encargo + ", estado=" + estado + '}';
    }
    
    
           
}
