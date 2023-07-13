/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generico;

/**
 *
 * @author aplaza
 */
public class General <T>
{
    T datoAlumno;
    
    public General()
    {
        datoAlumno=null;
    }
    
    public void setAlumno(T valor)
    {
        datoAlumno=valor;
    }
    
    public T getAlumno()
    {
        return datoAlumno;
    }
}
