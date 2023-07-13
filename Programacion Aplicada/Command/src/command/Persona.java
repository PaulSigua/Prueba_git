/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

/**
 *
 * @author Jeiso
 */
public class Persona {
    private String nombre;
    private int mesesVacaciones;

    public Persona(String nombre) {
        this.nombre = nombre;
        
    }

    public String getNombre() {
        return nombre;
    }
    


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMesesVacaciones() {
        return mesesVacaciones;
    }

    public void setMesesVacaciones(int mesesVacaciones) {
        this.mesesVacaciones = mesesVacaciones;
    }
    
    public void mesesVacaciones(int diasVacaciones){
        if (mesesVacaciones >= 0 && mesesVacaciones <= 11) {
            System.out.println("Aún no cumple un año. No puede tener vacaciones");
        }
        else if (mesesVacaciones >= 12 && mesesVacaciones <= 23) {
            System.out.println("Tiene: " + (mesesVacaciones+1) + " dias de vacaciones.");
        }
        else if(mesesVacaciones >= 24 && mesesVacaciones<= 35){
            System.out.println("Tiene: "+ (mesesVacaciones+2) + " dias de vacaciones.");
        }
        else if(mesesVacaciones >= 36 && mesesVacaciones <= 47){
            System.out.println("Tiene: " + (mesesVacaciones+3) + " dias de vacaciones.");
        }
        
    }
    public void sueldoFinal(int mesesTrabajados){
        int sueldo;
        if(mesesTrabajados%12 == 0){
            sueldo = (mesesTrabajados/12)*100;
        }else{
            sueldo = ((mesesTrabajados/12)*100)+(((mesesTrabajados%12)/2)*10);
        }
        System.out.println("Su sueldo es de $" + sueldo );
    }
}
