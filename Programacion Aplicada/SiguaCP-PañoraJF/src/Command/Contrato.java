/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Contrato {

    private String nombre;
    private int meses;
    private int dias = 10;
    private int sueldo;

    public Contrato(String nombre) {
        this.nombre = nombre;
    }

    public void determinarVacaciones(int mesesIngresados) {
        int anio = mesesIngresados/12;
        if (anio > 1) {
            dias = dias+(anio - 1);
        }
        System.out.println("Tiene " + dias + " dias de vacaciones");
        
    }

    public void determinarSueldo(int mesesIngresado) {
        if (mesesIngresado % 12 == 0) {
            sueldo = (mesesIngresado / 12) * 100;
        } else {
            sueldo = ((mesesIngresado / 12) * 100) + (((mesesIngresado % 12) / 2) * 10);
        }
        System.out.println("Su sueldo es de $" + sueldo);
    }

    public String getNombre() {
        return nombre;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

}
