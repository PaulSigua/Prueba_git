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
public class Operacion <T extends Number>
{
    T num;
    
    Operacion(T n)
    {
        num=n;
    }
    
    public double obtenerFraccion()
    {
        return num.doubleValue()-num.intValue();
    }
}
