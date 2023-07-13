/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodo;

/**
 *
 * @author aplaza
 */
public class Alumno 
{
    int edad;
    String nombre;
    
    public Alumno(int edad, String nombre)
    {
        this.edad=edad;
        this.nombre=nombre;
    }
    
    public String toString()
    {
        return edad+" "+nombre;
    }
}
