/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generica;

/**
 *
 * @author LENOVO
 */
public class Jefe extends CalcularSalario{
    private String nombre;
    private String id;
    private double horas;
    private double horasExtras;
    private double salario;

    public Jefe(String nombre, String id, double horas, double horasExtras) {
        this.nombre = nombre;
        this.id = id;
        this.horas = horas;
        this.horasExtras = horasExtras;
        this.salario = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public double getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    @Override
    public void calcularSalario() {
        if (getHoras() >=1) {
            System.out.println("Salario: " + (getHoras() * 1.5));
        }
        if (getHorasExtras()==1) {
            System.out.println("Salario con horas extras: " + (((getHoras()*1.5) + (getHorasExtras()*1.5))));
        }else{
            System.out.println("Salario con horas extras es: "+(((getHoras()*1.5) + (getHorasExtras()*1.00))));
        }
    }
}
