/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciageneric;

/**
 *
 * @author aplaza
 */
public class Generica <T>
{
    T dato;
    
    public Generica()
    {
        dato=null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }
    
    public static void imprimir(Generica<? extends Persona> p)
    {
        Persona dato=p.getDato();
        System.out.println (dato.cedula+" "+dato.nombre+" "+dato.edad);
    }
}
