/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiposlimitados;

/**
 *
 * @author aplaza
 */
public class Inicio 
{
    public static void main (String args[])
    {
        Operacion <Integer> op=new Operacion<Integer> (5);
        System.out.println (op.obtenerFraccion());
        
        Operacion <Double> op1=new Operacion<Double> (5.32);
        System.out.println (op1.obtenerFraccion());
        
        Puntos<Integer,Integer> p1=new Puntos<Integer,Integer>(2,3);
        
        Puntos<Number,Double> p2=new Puntos<Number,Double>(2.3,3.5);
        
        //Puntos<Number,String> p3=new Puntos<Number,String>(2.3,"a");
    }
}
