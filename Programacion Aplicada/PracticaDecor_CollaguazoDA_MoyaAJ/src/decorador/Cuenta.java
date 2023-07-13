/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorador;

/**
 *
 * @author Daniel Collaguazo Malla
 */
public class Cuenta {
    private int codigo;
    private String nombre;
    private boolean extraSeguro, extraMillas;

    public Cuenta(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isExtraSeguro() {
        return extraSeguro;
    }

    public void setExtraSeguro(boolean extraSeguro) {
        this.extraSeguro = extraSeguro;
    }

    public boolean isExtraMillas() {
        return extraMillas;
    }

    public void setExtraMillas(boolean extraMillas) {
        this.extraMillas = extraMillas;
    }
    
    
}
