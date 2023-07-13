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
public class Numero {
    private int par;
    private long impar;

    public Numero(int par, long impar) {
        this.par = par;
        this.impar = impar;
    }
    
    public int getNumero() {
        return par;
    }

    public void setNumero(int numero) {
        this.par = numero;
    }

    public long getImpar() {
        return impar;
    }

    public void setImpar(long impar) {
        this.impar = impar;
    }

    @Override
    public String toString() {
        return "Numero{" + "par=" + par + ", impar=" + impar + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.par;
        hash = 37 * hash + (int) (this.impar ^ (this.impar >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Numero other = (Numero) obj;
        if (this.par != other.par) {
            return false;
        }
        if (this.impar != other.impar) {
            return false;
        }
        return true;
    }
    
    
}
