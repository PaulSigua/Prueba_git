/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LENOVO
 */
public class Orden {
    private String tipo;
    private String tamanio;
    private String borde;
    private String extras;

    public Orden(String tipo, String tamanio, String borde, String extras) {
        this.tipo = tipo;
        this.tamanio = tamanio;
        this.borde = borde;
        this.extras = extras;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getBorde() {
        return borde;
    }

    public void setBorde(String borde) {
        this.borde = borde;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    @Override
    public String toString() {
        return "Orden: " + "tipo:" + tipo + ", tamaño:" + tamanio + ", borde:" + borde + ", extras:" + extras + '.';
    }

}
