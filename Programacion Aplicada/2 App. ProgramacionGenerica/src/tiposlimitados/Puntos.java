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
public class Puntos <T,V extends T>
{
    T primero;
    V segundo;
    
    Puntos(T a, V b)
    {
        primero=a;
        segundo=b;
    }
}
