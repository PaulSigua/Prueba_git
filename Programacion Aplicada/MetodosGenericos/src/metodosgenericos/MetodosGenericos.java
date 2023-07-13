/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosgenericos;

import java.util.GregorianCalendar;

/**
 *
 * @author LENOVO
 */
public class MetodosGenericos {

    public static void main(String[] args) {
        
        String nombres[] = {"o", "a", "c"};
        
        //System.out.println(MisMatrices.getMenor(nombres));
        
        /*Empleado uno = new Empleado("Martin", 30, 3000);
        
        Empleado uno = new Empleado("Maria", 30, 3000);
        
        Empleado uno = new Empleado("Marco", 30, 3000);
        
        Empleado misEmpleados[] = {martin, maria, marco};
        
        System.out.println(MisMatrices.getMenor(MisMatrices));
        */
        
        GregorianCalendar fechas[] ={new GregorianCalendar(2022, 10, 06), new GregorianCalendar(2022, 07, 01), new GregorianCalendar(2022, 03, 06)};
                
        System.out.println(MisMatrices.getMenor(fechas));        
        
        /*String element = MisMatrices.getElement(nombres);
        
        System.out.println(element);
        
        Empleado listaEmpleados[] = {new Empleado("Maria", 50, 500),
        new Empleado("Maria", 50, 500),
        new Empleado("Maria", 50, 500),
        new Empleado("Maria", 50, 500),
        new Empleado("Maria", 50, 500),
        new Empleado("Maria", 50, 500)};
        
        System.out.println(MisMatrices.getElement(listaEmpleados));
        */
        
    }
    
}

class MisMatrices{
    
    public static <T extends Comparable> T getMenor(T[]a){
        if(a==null || a.length==0){
            return null;
        }
        
        T elementoMenor = a[0];
        
        for(int i = 1; i < a.length; i++){
            if(elementoMenor.compareTo(a[i])>0){
                elementoMenor=a[i];
            }
        }
        return  elementoMenor;
    }
    
    /*public static <T> String getElement(T[]a){
        return "El array tiene " + a.length + " elementos";
    }*/
}
